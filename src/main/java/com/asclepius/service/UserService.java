package com.asclepius.service;

import com.asclepius.mapper.UserMapper;
import com.asclepius.pojo.User;
import com.asclepius.pojo.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

	@Resource
	UserMapper userMapper;

	public int createOrUpdate(User user) {
		int uId;
		UserExample example = new UserExample();
		example.createCriteria().andAccountIdEqualTo(user.getAccountId());
		List<User> users = userMapper.selectByExample(example);
		// 如果没有创建过，则创建
		if (users.size() == 0) {
			long time = System.currentTimeMillis();
			user.setGmtCreated(time);
			user.setGmtModified(time);
			userMapper.insert(user);
			uId = user.getuId();
		} else {
			User dbUser = users.get(0);
			dbUser.setGmtModified(System.currentTimeMillis());
			userMapper.updateByExample(dbUser, example);
			uId = dbUser.getuId();
		}
		return uId;
	}
}
