package za.ac.cput.controller.test;

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
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {
    private static final Admin admin = AdminFactory.createAdmin("Billie", "BillieJ2023", "billiej@gmail.com", "0617895230");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/admin";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(url, admin, Admin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Admin savedAdmin = postResponse.getBody();
        System.out.println("Saved Data: " + savedAdmin);
        assert admin != null;
        assertEquals(admin.getAdminId(), savedAdmin.getAdminId());
    }

    @Test
    void b_read() {
        assert admin != null;
        String url = baseURL + "/read/" + admin.getAdminId();
        System.out.println("URL: " + url);
        ResponseEntity<Admin> response = restTemplate.getForEntity(url, Admin.class);
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        assert admin != null;
        Admin update = new Admin.Builder().builder(admin).setAdminPassword("Billie_J_2023").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + update);
        ResponseEntity<Admin> response = restTemplate.postForEntity(url, update, Admin.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/";
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}