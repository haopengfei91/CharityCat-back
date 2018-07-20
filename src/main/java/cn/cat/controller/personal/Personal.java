package cn.cat.controller.personal;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cat.pojo.UserPojo;
import cn.cat.service.PersonalService;

@RestController
@RequestMapping("/personal")
public class Personal {
	@Autowired
	private PersonalService personalService;

	@GetMapping("/info/{id}")
	public Map<String, Object> info(@PathVariable String id) {
		return personalService.info(id);
	}
	
	@PutMapping("/update")
	public Map<String,String> updateInfo(UserPojo man){
		return personalService.updateInfo(man);
	}
}
