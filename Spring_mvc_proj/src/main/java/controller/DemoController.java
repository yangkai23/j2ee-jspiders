package controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dto.Demo;

public class DemoController {
	public DemoController() {
		System.out.println("Controller Object created!!!");
	}
	@RequestMapping(value = "form",method = RequestMethod.POST)
	public ModelAndView display(@ModelAttribute Demo demo) {
		String message="message is "+demo.getName();
		return new ModelAndView("success", "Anirudh", message);
	}
	@RequestMapping(value = "form1",method = RequestMethod.POST)
	public String displayNew(@ModelAttribute Demo demo , ModelMap map) {
		System.out.println("inside displaynew");
		String message ="new message is "+demo.getName();
		map.addAttribute(message);
		return "seccess";
		}
}
