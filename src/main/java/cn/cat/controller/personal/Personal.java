package cn.cat.controller.personal;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.cat.service.PersonalService;

@RestController
@RequestMapping("/personal")
public class Personal {
	@Autowired
	private PersonalService personalService;

	@RequestMapping("/info/{id}")
	public Map<String, Object> info(@PathVariable String id) {
		return personalService.info(id);
	}
}
