package com.min.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.dao.PayDao;
import com.min.vo.PayVo;


@Controller
public class payController{
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private PayDao dao;
	
	//결제페이지 이동
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {
		
		return "user/payments";
	}
	
	//관리자 결제정보 전체조회로 이동
	@RequestMapping(value = "/adminSelectPay.do", method = RequestMethod.GET)
	public String adminSelectPay(Model model) {
		logger.info("--------adminSelectPay 이동--------");
		List<PayVo> lists = dao.paySelectAll();
		model.addAttribute("lists",lists);
		return "admin/adminSelectPay";
	}
	
	//관리자 전체조회 상태별 조회
	@RequestMapping(value = "/changePage.do", method = RequestMethod.GET)
	public String changePage(String getText,Model model) {
		System.out.println(getText);
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status", getText);
		List<PayVo> lists = dao.paySelectStatus(map);
		model.addAttribute("lists",lists);
		model.addAttribute("status",getText);
		return "admin/adminSelectPay";
	}
	
	//관리자 환불신청 페이지 이동
	@RequestMapping(value = "/changeStatus.do", method = RequestMethod.GET)
	public String changeStatus(Model model) {
		logger.info("-----changeStatus 이동 -------");
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status","환불대기");
		List<PayVo> lists = dao.paySelectStatus(map);
		model.addAttribute("lists",lists);
		return "admin/changeStatus";
	}
	
	//관리자 환불신청 상태별 페이지 변경
	@RequestMapping(value = "/changeStatusSelect.do", method = RequestMethod.GET)
	public String changeStatusSelect(String getText,Model model) {
		System.out.println(getText);
			
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status", getText);
		List<PayVo> lists = dao.paySelectStatus(map);
		model.addAttribute("lists",lists);
		model.addAttribute("status",getText);
		return "admin/changeStatus";
	}
}
