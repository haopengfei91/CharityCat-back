package cn.cat.controller.cat;

import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cat.pojo.CatPojo;
import cn.cat.query.LimitQuery;
import cn.cat.service.CatService;

@RestController
@RequestMapping("/cat")
public class Cat {
	@Autowired
	private CatService catService;
	@Autowired
	DataSource ds;

	@GetMapping("/cat-list")
	public Map<String, Object> catList(LimitQuery query) {
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/cat-release")
	public Map<String, String> catRelease(CatPojo cat) {
		System.out.println(cat);
		return catService.catRelease(cat);
	}
}
