package org.flipbox.controller;




import org.flipbox.models.UserFlipbox;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.flipbox.models.UserFlipbox;
import org.flipbox.dao.UserDao;
import org.flipbox.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@Autowired
	private UserDao uDao;
	private UserFlipbox userLogin;
	
	
	@Autowired
	public UserDao getuDao() {
		return uDao;
	}
	@Autowired
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}
	@RequestMapping("/flipbox")
	public String index(Model model) {
		model.addAttribute("userbaru", new UserFlipbox());
		model.addAttribute("userLogin", new UserFlipbox());
		return "index";
		
	}
	@RequestMapping("/edit")
	public String edit() {
		return "editprofile";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveOrUpdateAkun(Model model,UserFlipbox userflipbox ) {
		model.addAttribute("user", uDao.saveOrUpdate(userflipbox));						
		return "login";
	}
	@RequestMapping("/flipbox/home")
	public String homeUser(Model model, HttpServletRequest request) {
		model.addAttribute("userLogin", new UserFlipbox());
		model.addAttribute("username", userLogin.getUsername());
		model.addAttribute("nama", userLogin.getNama_user());
		model.addAttribute("jk", userLogin.getJk_user());
		model.addAttribute("homeadr", userLogin.getAlamat());
		model.addAttribute("emailadr", userLogin.getEmail());
		model.addAttribute("phone", userLogin.getMobile_ph());
		return "homeuser";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		if(uDao.login(username, password) != null){
			System.out.print(username);
			request.getSession().setAttribute("userLogin", uDao.login(username, password));
			userLogin = (UserFlipbox) request.getSession().getAttribute("userLogin");
			return "redirect:/flipbox/home";
			
		}		
		return "redirect:/flipbox";
		
	}
	@RequestMapping("/editprofile")
	public String editprofile(Model model, HttpServletRequest request) {
		
		model.addAttribute("username", userLogin.getUsername());
		model.addAttribute("userup", uDao.saveOrUpdate(userLogin));
		return "layout";
	}
	
	
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logOut(HttpSession session)
	{
		session.removeAttribute("userLogin");
		return "login";
	}
	
}
