package controller;

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
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
    private static Customer customer = CustomerFactory.createCustomer("Joe","kan","0607864345","kan@gmail.com","Zola Square site c 7784");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customer";
    @Test
    void a_create() {
        String url = baseURL + "/create" ;
        ResponseEntity<Customer> postResponse = restTemplate. postForEntity(url, customer , Customer.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Customer addedCustomer = postResponse.getBody();
        System.out.println("Added data:" + addedCustomer);
        assertEquals(customer.getCustomerId(), postResponse.getBody().getCustomerId());


    }

    @Test
    void b_read() {
        String  url = baseURL + "/read" + customer.getCustomerId();
        System.out.println("URL:" + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url,Customer.class);
        assertEquals(customer.getCustomerId(), response.getBody().getCustomerId());
        System.out.println(response.getBody());

    }

    @Test
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setFirstName("John").build();
        String url = baseURL + "/update" ;
        System.out.println("URL:" + url);
        System.out.println("post data:" + updated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url,updated, Customer.class);
        assertNotNull(response.getBody());

    }

    @Test
    void e_delete() {
        String  url = baseURL + "/delete" + customer.getCustomerId();
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
