package com.lotaproject.bookTracking;

import com.lotaproject.bookTracking.model.MyUser;
import com.lotaproject.bookTracking.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyUserMsApplicationTests {

	@LocalServerPort
	private int port;

	private String baseUrl = "localhost:";

	private static RestTemplate restTemplate;

	@Autowired
	private  UserRepository userRepository;


	@BeforeAll
	public static void init(){
		restTemplate = new RestTemplate();

	}

	@BeforeEach
	public void setUp(){
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/users");

	}

	@Test
	void testAddUser(){
		MyUser user = new MyUser();
		user.setUsername("lota");
		user.setPassword("ouydfghj");

		MyUser response = restTemplate.postForObject(baseUrl,user,MyUser.class);
		assert response != null;
		assertEquals("lota", response.getUsername());
		assertEquals(1, userRepository.findAll().size());

	}

	@Test
	void contextLoads() {
	}

}
