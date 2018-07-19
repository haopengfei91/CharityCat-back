package cn.cat.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import cn.cat.cache.TokenCache;
import cn.cat.cache.VerificatCodeCache;
import cn.cat.factory.MailMessageFactory;
import cn.cat.mapper.MiaoManMapper;
import cn.cat.pojo.MiaoMan;
import cn.cat.query.UserLoginQuery;

@Service
public class UserService {
	@Autowired
	private MiaoManMapper mapper;
	@Autowired
	private TokenCache tokenCache;
	@Autowired
	private VerificatCodeCache verificatCodeCache;
	@Autowired
	private JavaMailSenderImpl mailSender;

	public Map<String, String> login(HttpServletRequest req, UserLoginQuery query) {
		Integer userId = mapper.findMiaoMan(query);
		Map<String, String> map = new HashMap<>();
		if (userId != null) {
			String token = req.getSession().getId();
			map.put("code", "200");
			map.put("id", userId.toString());
			map.put("token", token);
			map.put("message", "登陆成功");
			tokenCache.addToken(userId, token, 6);
			System.out.println(tokenCache);
		}
		return map;
	}

	public void VerificatCode(String mail) {
		String verificatCode = UUID.randomUUID().toString().substring(0, 8);
		verificatCodeCache.addVerificatCode(mail, verificatCode);
		mailSender.send(MailMessageFactory.getMailMessageTemplate(mail, verificatCode));
	}

	public Map<String, String> register(MiaoMan man, String verificatCode) {
		Map<String, String> map = new HashMap<>();
		man.setId(String.valueOf(new Date().getTime()));
		String mail = man.getMail();
		if (verificatCodeCache.getVerificatCode(mail).equals(verificatCode)) {
			if (mapper.findMiaoManByMail(mail) > 0) {
				map.put("code", "404");
				map.put("message", "该邮箱已被注册");
				return map;
			} else {
				mapper.insertMiaoMan(man);
				map.put("code", "200");
				map.put("message", "注册成功");
				verificatCodeCache.removeVerificatCode(mail);
				return map;
			}
		} else {
			map.put("code", "404");
			map.put("message", "验证码错误");
			return map;
		}
	}

	public Map<String, String> forgetPass(String mail, String newpass,String verificatCode) {
		return null;
	}
}
