package cn.cat.controller.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cat.mapper.MiaoManMapper;
import cn.cat.query.UserLoginQuery;
import cn.cat.task.TokenInfo;

@RestController
@RequestMapping("/user")
public class user {

	@Autowired
	private ApplicationContext ac;
	@Autowired
	private TokenInfo tokenInfo;

	@PostMapping("/login")
	public Map<String, String> login(HttpServletRequest req, UserLoginQuery query) throws Exception {
		MiaoManMapper mapper = ac.getBean(MiaoManMapper.class);
		Integer userId = mapper.findMiaoMan(query);
		Map<String, String> map = new HashMap<>();
		if (userId != null) {
			String token = req.getSession().getId();
			map.put("code", "200");
			map.put("token", token);
			map.put("id", userId.toString());
			tokenInfo.addToken(userId, token,1);
		
		}
		return map;
	}
}
