package za.ac.cput.controller.test;

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
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    private static final User user = UserFactory.createUser("Amelia", "58 Cockpit Road, Cape Town, 8000", "amelia@gmail.com", "0786542143");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/user";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User savedUser = postResponse.getBody();
        System.out.println("Saved Data: " + savedUser);
        assert user != null;
        assertEquals(user.getUserId(), savedUser.getUserId());
    }

    @Test
    void b_read() {
        assert user != null;
        String url = baseURL + "/read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        assert user != null;
        User update = new User.Builder().builder(user).setUserEmail("amelia_j@icloud.com").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + update);
        ResponseEntity<User> response = restTemplate.postForEntity(url, update, User.class);
        assertNotNull(response.getBody());
    }

    @Test
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