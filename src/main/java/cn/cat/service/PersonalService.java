package cn.cat.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import cn.cat.mapper.MiaoManMapper;
import cn.cat.pojo.MiaoMan;

@Service
public class PersonalService {
	@Autowired
	private MiaoManMapper mapper;

	public Map<String, Object> info(@PathVariable String id) {
		Map<String, Object> map = new HashMap<>();
		MiaoMan man = mapper.selectMiaoMan(id);
		if (man != null) {
			map.put("personalInfo", man);
			map.put("code", "200");
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "资源未找到");
			return map;
		}
	}
}
