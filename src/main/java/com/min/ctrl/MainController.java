package com.min.ctrl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.min.service.IMemberService;
import com.min.service.IPayService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping
public class MainController {

	@Autowired
	IMemberService service;
	
	@Autowired
	IPayService payService;
	
	//첫 메인페이지
	@RequestMapping(value = "/app/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("로그인전 메인 페이지");
		System.out.println("SecurityContextHolder 에 등록된 정보 확인");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( auth != null) {
			
			System.out.println("Authentication getAuthorities: " + auth.getAuthorities().toString());
			System.out.println("Authentication getPrincipal: " + auth.getPrincipal());
			System.out.println("Authentication getName: " +auth.getName());
			System.out.println("Authentication getCredentials: " + auth.getCredentials());
			System.out.println("Authentication getDetails: " + auth.getDetails());
			System.out.println("Authentication isAuthenticated: " + auth.isAuthenticated());
			
		}
		
		return "main";
	}
	//메인페이지 
	@RequestMapping(value = "/app/", method = RequestMethod.GET)
	public String LoginHome(Locale locale, Model model) {
		log.info("LoginHome 로그인전 메인 페이지");
		
		return "main";
	}
	
	// 로그인 페이지로 가는 매핑
		@RequestMapping(value = "/app/loginPage.do", method = {RequestMethod.GET})
		public String loginPage(
				Locale locale, Model model,Authentication user) {
			System.out.println(" loginPage 로그인 선택창 이동");

			return "loginForm";
		}
		
	// 마이페이지
		@RequestMapping(value = {"/user/myProfile.do", "/ins/myProfile.do"}, method = {RequestMethod.GET})
		public String myProfile(
				Locale locale, Model model,Authentication user) {
			log.info(" myProfile 마이페이지 이동 ");
			Map<String, Object> cmap = new HashMap<String, Object>();
			cmap.put("cou_tra_id", user.getPrincipal());
			cmap.put("cou_delflag", "Y");
			Map<String, Object> milemap = new HashMap<String, Object>();
			milemap.put("tra_id", user.getPrincipal());
			int coup = payService.countCoupon(cmap);
//			int mile = payService.myMilage(milemap);
			model.addAttribute("coup",coup);
//			model.addAttribute("mile",mile);
			
			return "user/myProfile";
		}
		
   // 개인정보 수정
		@RequestMapping(value = {"/user/editProfile.do", "/ins/editProfile.do"}, method = {RequestMethod.GET})
		public String editProfile(
		        Locale locale, Model model,Authentication user) {
			log.info("editProfile 개인정보 수정페이지 이동 ");
					
				return "user/editProfile";
		}

		@RequestMapping(value = "/app/logout.do", method = RequestMethod.GET)
		public String logout() {
			log.info("로그아웃 완료");
			return "redirect:/app/main";
		}
}
