package com.mycompany;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

	@RequestMapping("/hellodolphin")
	public String hello() {
		return "hellodolphin";
	}

}
