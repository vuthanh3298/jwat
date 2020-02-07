package controller;


import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Users;



@Controller
public class SignInSignUpController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@GetMapping("/dangnhap")
	public String dangNhap() {
		return "signin";
	}
	
	@PostMapping("/dangnhap")
	@Transactional
	public String xuLyDangNhap(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String sql = "from users where email= :email and password= :password";
			Query query = session.createQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			Users user = (Users) query.getSingleResult();
			if(user != null) {
				System.out.println(user.getUsername());
				modelMap.addAttribute("result", "true");
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("result", "false");
		return "signin";
	}
	
	@PostMapping("/dangky")
	public String xuLyDangKy(@ModelAttribute Users user) {
		
		
		System.out.println("chạy vào đăng kí");
		return "redirect:/";
	}
}
