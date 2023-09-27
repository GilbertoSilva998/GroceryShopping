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
import za.ac.cput.domain.Store;
import za.ac.cput.factory.StoreFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StoreControllerTest {

    private final Store store = StoreFactory.createStore("Woolworths", "Cape Town CBD", "Always with you");
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/store";


    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Store> postResponse = testRestTemplate.postForEntity(url, store, Store.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Store createdStore = postResponse.getBody();
        System.out.println("Created data: " + createdStore);
        assertEquals(store.getStoreId(), createdStore.getStoreId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + store.getStoreId();
        ResponseEntity<Store> responseEntity = testRestTemplate.getForEntity(url, Store.class);
        assertEquals(store.getStoreId(), responseEntity.getBody().getStoreId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        Store updatedStore = new Store.Builder().copy(store)
                .setStoreName("Pick n Pay")
                .build();

        String url = baseURL + "/update";
        ResponseEntity<Store> responseEntity = testRestTemplate.postForEntity(url, updatedStore, Store.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + store.getStoreId();
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