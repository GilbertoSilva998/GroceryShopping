package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryControllerTest {
    private static Category category = CategoryFactory.createCategory("Fruit","Banana");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/category";
    @Test
    void a_create() {
        String url = baseURL + "/create" ;
        ResponseEntity<Category> postResponse = restTemplate. postForEntity(url, category , Category.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Category addedCategory = postResponse.getBody();
        System.out.println("Added data:" + addedCategory);
        assertEquals(category.getCategoryId(), postResponse.getBody().getCategoryId());


    }

    @Test
    void b_read() {
        String  url = baseURL + "/read" + category.getCategoryId();
        System.out.println("URL:" + url);
        ResponseEntity<Category> response = restTemplate.getForEntity(url,Category.class);
        assertEquals(category.getCategoryId(), response.getBody().getCategoryId());
        System.out.println(response.getBody());

    }
    @Test
    void update() {
        Category updated = new Category.Builder().copy(category).setCategoryType("Peach").build();
        String url = baseURL + "/update" ;
        System.out.println("URL:" + url);
        System.out.println("post data:" + updated);
        ResponseEntity<Category> response = restTemplate.postForEntity(url,updated, Category.class);
        assertNotNull(response.getBody());

    }
    @Test
    void e_delete() {
        String  url = baseURL + "/delete" + category.getCategoryId();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }
    @Test
    void d_getAll() {
        String url = baseURL + "/getall" ;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
