package cn.cat.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cat.mapper.CatMapper;
import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;
import cn.cat.util.RandomIdUtil;

@Service
public class CatService {
	@Autowired
	private CatMapper mapper;

	public Map<String, Object> catList(LimitQuery query) {

		return null;
	}

	public Map<String, String> catRelease(CatPojo cat) {
		cat.setCatid(RandomIdUtil.randomOtherId());
		Integer i = mapper.insertCat(cat);
		Map<String, String> map = new HashMap<>();
		System.out.println(i);
		if (i > 0) {
			map.put("code", "200");
			map.put("message", "发布成功");
			return map;
		} else {
			map.put("code", "404");
			map.put("message", "发布失败");
			return map;
		}
	}
}
