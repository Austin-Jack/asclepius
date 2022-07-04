package com.asclepius.controller.card;

import cn.hutool.json.JSONUtil;
import com.asclepius.common.ResponseCode;
import com.asclepius.mapper.CardMapper;
import com.asclepius.mapper.UserMapper;
import com.asclepius.pojo.Card;
import com.asclepius.pojo.CardExample;
import com.asclepius.pojo.User;
import com.asclepius.utils.GenToken;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.util.List;

import static com.asclepius.utils.GenerateMockData.*;

/*固定这么写*/
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardControllerTest {

	//请求URL前缀
	private static final String URL_PREFIX = "/api/private/user";

	//固定不变
	@Autowired
	MockMvc mockMvc;

	//要用的访问数据库的类 User对应UserMapper
	@Resource
	UserMapper userMapper;

	//要用的访问数据库的类 Card对应CardMapper
	@Resource
	CardMapper cardMapper;

	//虚拟用户
	User testUser;

	//虚拟卡
	Card testCard;

	//用于条件查询
	CardExample cardExample;

	HttpHeaders headers;


	@Before
	public void setUp() {
		//生成虚拟用户
		testUser = generateUser();
		//插入虚拟用户 同时会将出入后返回的uId值存入testUser的uId字段
		userMapper.insert(testUser);

		/*固定这样写*/
		headers = new HttpHeaders();
		headers.set(HttpHeaders.AUTHORIZATION, GenToken.sign(testUser.getAccountId()));
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		//生成用户的虚拟卡
		testCard = generateCard(testUser);
		//实例化条件查询
		cardExample = new CardExample();
		//查询条件为uId等于testUser的uId 并且状态等于1
		cardExample.createCriteria().andUIdEqualTo(testUser.getuId()).andCStatusEqualTo(1);
		//插入虚拟卡 Selective意思是仅插入有值的字段
		cardMapper.insertSelective(testCard);
	}


	@Test
	@Order(1) //设置请求次序 为1
	//测试添加卡
	public void addCard() throws Exception {
		//新建一个post请求并设置请求头
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(URL_PREFIX + "/addCard").headers(headers);
		//生成两张虚拟卡
		Card card1 = generateCard(testUser);
		Card card2 = generateCard(testUser);

		//携带请求体为card1转为的Json字符串
		request.content(JSONUtil.toJsonStr(card1));

		//添加第一张卡
		mockMvc.perform(request)
				//响应状态码为ok
				.andExpect(MockMvcResultMatchers.status().isOk())
				//取出响应题的code字段值为ResponseCode.OK
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				//打印整个请求过程
				.andDo(MockMvcResultHandlers.print());

		//添加第二张卡
		request.content(JSONUtil.toJsonStr(card2));
		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK)).andDo(MockMvcResultHandlers.print());
		//查询一下testUser拥有的就诊卡
		List<Card> cards = cardMapper.selectByExample(cardExample);
		//断言数量为3 因为在setUp阶段固定添加了一张卡
		Assert.assertEquals(3, cards.size());
	}

	@Test
	@Order(2)
	public void deleteCard() throws Exception {
		//新建delete请求  拼接请求地址为/api/private/user/deleteCard/{uId}/{cId}
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.delete(URL_PREFIX + "/deleteCard/" + testUser.getuId() + "/" + testCard.getcId()).headers(headers);
		//发起请求
		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				//取出请求头的code字段值期待为 ResponseCode.OK
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK)).andDo(MockMvcResultHandlers.print());
		//查询testUser的所有卡
		List<Card> cards = cardMapper.selectByExample(cardExample);
		//期待的是用户已经没有有效就诊卡了
		Assert.assertEquals(0, cards.size());
	}

	@Test
	@Order(3)
	public void alterCard() throws Exception {
		//设置需要修改的内容
		testCard.setTelNumber(generatesTelNum());
		testCard.setAge(100);
		testCard.setName(generateName());
		//声明请求
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.post(URL_PREFIX + "/alterCard")
						.headers(headers)
						.content(JSONUtil.toJsonStr(testCard));
		//发起请求并断言
		mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				.andDo(MockMvcResultHandlers.print());

		//	将卡片的信息置为不合法 例如把uId置为-1
		testCard.setuId(-1);
		request.content(JSONUtil.toJsonStr(testCard));
		//发起请求并断言
		mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.NOT_FOUND))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(4)
	public void getCards() throws Exception {
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders.get(URL_PREFIX + "/getCards?uId=" + testUser.getuId())
						.headers(headers);
		//根据接口传入参数
		mockMvc.perform(request)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(ResponseCode.OK))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].cId").value(testCard.getcId()))
				.andDo(MockMvcResultHandlers.print());
	}

	@After
	public void destroy() {
		cardMapper.deleteByPrimaryKey(testCard.getcId());
		userMapper.deleteByPrimaryKey(testUser.getuId());
	}
}