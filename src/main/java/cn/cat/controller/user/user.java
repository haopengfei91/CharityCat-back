package cn.cat.controller.user;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class user {
	
	@Autowired
	DataSource datasource;
	
	@RequestMapping("/login")
	public void login() throws Exception {
		System.out.println(datasource.getConnection());
		System.out.println("login");
	}
}
