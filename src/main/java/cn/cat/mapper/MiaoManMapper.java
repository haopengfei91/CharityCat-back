package cn.cat.mapper;

import cn.cat.pojo.MiaoMan;
import cn.cat.query.UserLoginQuery;

public interface MiaoManMapper {
	public Integer findMiaoMan(UserLoginQuery query);
	public void insertMiaoMan(MiaoMan man);
	public Integer findMiaoManByMail(String mail);
	public Integer updateMiaoManPass(String mail,String password);
}
