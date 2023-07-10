package com.devtool.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestCotroller {
	
	@RequestMapping("/test")
	public String test() {
		return "This is simple test controller";
	}

}
