package com.asclepius;

import com.asclepius.utils.GenToken;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:application.yml")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AsclepiusApplication.class)
class AsclepiusApplicationTests {


	@Test
	void contextLoads() {
		System.out.println(GenToken.sign(String.valueOf(123), 123));
	}

}
