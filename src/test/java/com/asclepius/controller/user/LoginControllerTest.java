package com.asclepius.controller.user;

import com.asclepius.common.ResponseCode;
import com.asclepius.mapper.UserMapper;
import com.asclepius.pojo.User;
import com.asclepius.pojo.UserExample;
import com.asclepius.service.LoginService;
import com.asclepius.utils.GenToken;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
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
import org.springframework.util.Assert;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.util.Objects;

import static com.asclepius.utils.GenerateMockData.generateOpenID;
import static com.asclepius.utils.GenerateMockData.generateUser;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LoginService loginService;


	@Resource
	UserMapper userMapper;

	User testUser;

	@Before
	public void setUp() {
		testUser = generateUser();
		userMapper.insert(testUser);
	}

	@Test
	@Order(1)
	/***
	 * 测试验证码不存在的登录情况
	 * @param
	 * @return void
	 **/ public void login() throws Exception {
		//设置为当调用loginService.verify时不管入参是什么字符串都会返回null
		Mockito.when(loginService.verify(Mockito.anyString())).thenReturn(null);

		/*向/api/login/7856发送一个get请求 */
		mockMvc.perform(MockMvcRequestBuilders.get("/api/login/7856"))
				/*期待HTTP响应的状态码为ok*/.andExpect(MockMvcResultMatchers.status().isOk())
				//期待返回的响应体中的code字段值为UNPROCESSABLE_ENTITY 即422
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.UNPROCESSABLE_ENTITY)).andDo(MockMvcResultHandlers.print());

	}

	@Test
	@Order(2)
	/**
	 * 测试用户第一次登录的情况
	 * @param
	 * @return void
	 **/ public void testLogin2() throws Exception {
		//设置为当调用loginService.verify时入参为2594时返回预定的userId
		Mockito.when(loginService.verify("2594")).thenReturn(testUser.getAccountId());
		UserExample example = new UserExample();
		example.createCriteria().andAccountIdEqualTo(testUser.getAccountId());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/login/2594"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.uId").value(userMapper.selectByExample(example).get(0).getuId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.token").value(Objects.requireNonNull(GenToken.sign(testUser.getAccountId(), testUser.getuId()))))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(3)
	/**
	 * 测试已存在用户的情况下的登录
	 * @param
	 * @return void
	 **/ public void testLogin3() throws Exception {
		Mockito.when(loginService.verify("3359")).thenReturn(testUser.getAccountId());
		UserExample example = new UserExample();
		User realUser;
		example.createCriteria().andAccountIdEqualTo(testUser.getAccountId());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/login/3359"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.uId").value((realUser =
						userMapper.selectByExample(example).get(0)).getuId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.token").value(Objects.requireNonNull(GenToken.sign(testUser.getAccountId(), testUser.getuId()))))
				.andDo(MockMvcResultHandlers.print());
		Assert.isTrue(testUser.getGmtModified() < realUser.getGmtModified());
	}

	@After
	public void destroy() {
		userMapper.deleteByPrimaryKey(testUser.getuId());
	}
}