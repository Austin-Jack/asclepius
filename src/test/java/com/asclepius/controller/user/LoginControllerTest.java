package com.asclepius.controller.user;

import com.asclepius.common.ResponseCode;
import com.asclepius.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LoginService loginService;

	String userId;


	@Before
	public void setUp() {
		userId = "298372";
	}

	@Test
	public void login() throws Exception {
		//设置为当调用loginService.verify时不管入参是什么字符串都会返回null
		Mockito.when(loginService.verify(Mockito.anyString())).thenReturn(null);

		/*向/api/login/7856发送一个get请求 */
		mockMvc.perform(MockMvcRequestBuilders.get("/api/login/7856"))
				/*期待HTTP响应的状态码为ok*/
				.andExpect(MockMvcResultMatchers.status().isOk())
				//期待返回的响应体中的code字段值为UNPROCESSABLE_ENTITY 即422
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.UNPROCESSABLE_ENTITY))
				.andDo(MockMvcResultHandlers.print());

		//设置为当调用loginService.verify时入参为2594时返回预定的userId
		Mockito.when(loginService.verify("2594")).thenReturn(userId);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/login/2594"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value(userId))
				.andDo(MockMvcResultHandlers.print());
	}
}