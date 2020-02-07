package controller;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DanhSachTaiKhoan {
	
	@GetMapping("/danhsachtaikhoan")
	@Transactional
	public String danhsachtaikhoan(ModelMap modelMap) {
		
		return "DanhSachTaiKhoan"; 
	}
}
