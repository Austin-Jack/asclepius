package com.asclepius;

import com.asclepius.utils.GenToken;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = AsclepiusApplication.class)
@AutoConfigureMockMvc
class AsclepiusApplicationTests {


	@Test
	void contextLoads() {
	}

}
