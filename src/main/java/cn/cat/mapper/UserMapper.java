package cn.cat.mapper;

import cn.cat.pojo.UserPojo;
import cn.cat.query.UserLoginQuery;

public interface UserMapper {
	public String findUser(UserLoginQuery query);

	public void insertUser(UserPojo man);

	public Integer findUserByMail(String mail);

	public Integer updateUserPass(String mail, String password);

	public UserPojo findUserById(String id);

	public Integer updateUserInfo(UserPojo man);
}
