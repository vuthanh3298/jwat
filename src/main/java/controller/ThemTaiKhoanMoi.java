package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ThemTaiKhoanMoi {
	@GetMapping("/themtaikhoanmoi")
	public String themtaikhoanmoi() {
		return "ThemTaiKhoanMoi";
	}
}
