// UserControllerIntegrationTest.java
package com.springboot.userserver.controller;

import com.springboot.userserver.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerIntegrationTest {

    @LocalServerPort
    private int port = 8080; // 明确指定端口

    @Autowired
    private TestRestTemplate restTemplate;

    // 测试添加用户
    @Test
    void testAddUser() {
        User newUser = new User();
        newUser.setUserName("integrationTest");
        newUser.setPhone("13800138000");

        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/user",
                newUser,
                String.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("success"));
    }

    // 测试更新用户
    @Test
    void testUpdateUser() {
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setUserName("updatedUser");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(updatedUser, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/user",
                HttpMethod.PUT,
                request,
                String.class
        );

        assertEquals(200, response.getStatusCodeValue());
    }
}