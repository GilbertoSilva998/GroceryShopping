package controller;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    private final Product product = ProductFactory.createProduct(20, "Bakery","Bread", "Albany");
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/product";


    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Product> postResponse = testRestTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Product createdProduct = postResponse.getBody();
        System.out.println("Created data: " + createdProduct);
        assertEquals(product.getProductId(), createdProduct.getProductId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + product.getProductId();
        ResponseEntity<Product> responseEntity = testRestTemplate.getForEntity(url, Product.class);
        assertEquals(product.getProductId(), responseEntity.getBody().getProductId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        Product updatedProduct = new Product.Builder().copy(product)
                .setProductItem("Buns")
                .build();

        String url = baseURL + "/update";
        ResponseEntity<Product> responseEntity = testRestTemplate.postForEntity(url, updatedProduct, Product.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + product.getProductId();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}