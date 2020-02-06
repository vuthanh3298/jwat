package controller;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import entity.Roles;



@Controller
//@RequestMapping("/")
public class HomeController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping ("/")
	@Transactional
	public String index() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "from roles";
		List<Roles> roles = session.createQuery(sql).getResultList();
		for(Roles role : roles) {
			System.out.println(role.getDislayName());
		}
		return "home";
	}
}
