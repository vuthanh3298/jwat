package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class TaiKhoanChoDuyet {
	@GetMapping("/taikhoanchoduyet")
	public String taikhoanchoduyet() {
		return "TaiKhoanChoDuyet";
}
}
