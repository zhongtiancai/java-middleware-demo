package hello;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HelloController {
	String pre = "user_";

	@Resource(name="redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	@RequestMapping(value="/index1",method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping("/saveJson")
	@ResponseBody
	public User saveJson(@RequestBody User user) {
		redisTemplate.opsForValue().set(pre + user.getId(), user.getName());
		return user;
	}

}
