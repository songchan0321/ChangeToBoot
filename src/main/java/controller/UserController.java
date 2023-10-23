package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.User;
import repository.UserRepository;
import service.UserService;



@RestController
@RequestMapping("/user/*")
public class UserController {

	///Field
	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserService userService;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/enterForm")
	public String joinForm() {
		return "enter";
	}

	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "user";
	}

	@GetMapping("/commander")
	@ResponseBody
	public String commander() {
		return "commander";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin";
	}
	@GetMapping("/kakao/callback")
	public ResponseEntity<Map<String, Object>> kakaoLogin(@RequestParam("code") String code) throws Exception {
		// authorizedCode: 카카오 서버로부터 받은 인가 코드
		System.out.println("code : " + code);
		Map<String, Object> map = userService.kakaoLogin(code);
		return ResponseEntity.ok(map);
	}
}