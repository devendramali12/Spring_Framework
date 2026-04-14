
package com.tyss;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

//@RestController
@Controller
public class TestController {

	// API
	@GetMapping("/test")
	public String testApi() {
		System.out.println("This is testAPI");
		return "Hello";
	}

	@GetMapping("/msg")
	public String msg() {
		System.out.println("This is msg api");
		return "msg.jsp";
	}

	@GetMapping("/user")
	public String userDataPage() {
		return "userdata.jsp";
	}

	@PostMapping("/read") // Only POST
	public String readData(HttpServletRequest request) {

		String un = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("password");

		System.out.println("-------------User Data-------------");
		System.out.println(un);
		System.out.println(email);
		System.out.println(phone);
		System.out.println(pwd);

		return "userdata.jsp";
	}

	@RequestMapping("/send")
	public String sendData(Model model) {

		System.out.println("Data sent to jsp page");

		String name = "Mark";
		int age = 32;

		model.addAttribute("username", name);
		model.addAttribute("userage", age);

		return "display.jsp";
	}

	@RequestMapping("/send-data")
	public ModelAndView send_Data() {

		System.out.println("Data sent to jsp page");

		String name = "Mark";
		int age = 54;

		Student s = new Student("Penga", 22, 45678);

		ModelAndView mv = new ModelAndView("details.jsp");
//		mv.setViewName("details.jsp");
		mv.addObject("username", name);
		mv.addObject("userage", age);
		mv.addObject("stud", s);// student object

		return mv;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String readuserData(User user) {
		System.out.println(user);
		return "register.jsp";
	}

}
