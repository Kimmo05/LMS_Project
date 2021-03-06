package com.min.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.vo.FileVo;
import com.min.service.IMemberService;
import com.min.utils.MailUtil;
import com.min.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import okhttp3.internal.framed.Header;


@Controller
@Slf4j
@RequestMapping(value = "/user/*")
public class UserLoginController {

	@Autowired
	IMemberService service;
	@Autowired
	PasswordEncoder password;
	

	
	
	//????????? ??? ???????????? ???????????????
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String traMainPage(Locale locale, Model model,Authentication user) {
		log.info("traMainPage ??????????????? ??????");
		
		
		return "main";
	}
	//???????????? ???????????????????????? ?????????????????????
	@RequestMapping(value = "/reMain.do", method = RequestMethod.GET)
	public String redirectHome(Locale locale, Model model,Authentication user) {
		log.info("redirectHome ??????????????? ??????");
		
		
		return "redirect:/app/";
	}
	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/loginPage.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String traLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {
		
		log.info("traLogin ???????????? ????????? ????????? ??????");
//		UserDetails userdto = (UserDetails) user.getPrincipal();
//		System.out.println("---------------"+userdto);
//		model.addAttribute("user", userdto.toString());
		  
		if (error != null) {
			model.addAttribute("msg", "????????? ??????");
		}

		if (logout != null) {
			model.addAttribute("msg", "???????????? ??????");
		}
		
		if(user != null) {
			return "redirect:/user/result.do";
		}
		
		return "TraLoginForm";
	}

	//????????? ?????? ??? ?????? ???????????? ?????? ??????
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String mainLoginTra(Authentication user, Model model , HttpSession session) {
		
		log.info("?????????  ????????? ?????? ??????");
		Enumeration<?> session_attributes = session.getAttributeNames();
		while(session_attributes.hasMoreElements()) {
	        String session_name  = session_attributes.nextElement().toString();
	        String session_value = session.getAttribute(session_name).toString();
	        System.out.println("?????????: "+ session_name);
	        System.out.println("?????????: " +session_value);
		}
		
		log.info("SecurityContextHolder ??? ????????? ?????? ??????");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( auth != null) {
			
			System.out.println("Authentication getAuthorities: " + auth.getAuthorities().toString());
			System.out.println("Authentication getPrincipal: " + auth.getPrincipal());
			System.out.println("Authentication getName: " +auth.getName());
			System.out.println("Authentication getCredentials: " + auth.getCredentials());
			System.out.println("Authentication getDetails: " + auth.getDetails());
			System.out.println("Authentication isAuthenticated: " + auth.isAuthenticated());
			
		}
		log.info("mainLoginTra ????????? ??????");
//		UserDetails userdto = (UserDetails) auth.getDetails();
//		model.addAttribute("user", userdto.toString());
//		System.out.println(":::::::::::::::::::::::: " +auth.getPrincipal());
//		System.out.println("???????????? : " + userdto.getPassword());
		return "main";
	}


	//?????????????????? ?????? ??????
	@RequestMapping(value = "/traSignUp.do", method = RequestMethod.GET)
	public String traSignUp() {
		log.info("traSignUp ???????????? ????????? ??????");
		return "traRegister";
	}


	// ???????????? ?????? ??????
	@RequestMapping(value = "/traSingUpSc.do", method = RequestMethod.POST)
	public String traSingUpSc(@RequestParam Map<String, Object> map, Model model) {
		System.out.println("???????????? ??????"+map);
		log.info("traSingUpSc ???????????? ?????? {} ",map);
		service.traSignUp(map);
		log.info("traSingUpSc ?????????????????? ????????? ????????? ??????");
		return "redirect:/user/loginPage.do";
	}
	
	//???????????? ???????????? ??????
	@RequestMapping(value = "/editUser.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String  editUserProfile(@RequestParam Map<String, Object> map, Model model,Authentication user) {
		MemberVo mvo = (MemberVo) user.getDetails();
		map.put("id", mvo.getId());
		

		log.info("editUserProfile ???????????? ?????? {}",mvo);
		service.updateTra(map);

		
		log.info("editUserProfile ???????????? ?????? ??????");
		
		
		return "redirect:/user/logout.do";
	
	}
	
	
	
	//????????? ??????
		@RequestMapping(value = "/findTraIdView.do", method = RequestMethod.GET)
		public String findTraIdView() {
			log.info("findTraIdView ????????? ??????");
			return "findTraId";
		}


		//????????? ??????
		@RequestMapping(value = "/findTraId.do", method = RequestMethod.POST)
		public @ResponseBody  Map<String, String> findTraId (@RequestParam Map<String, Object> map, Model model) {
			Map<String, String> rMap = new HashMap<String, String>();
			log.info("  Member_Controller findTraId : {} ", map);
			MemberVo mVo = service.findTraId(map);
			
			log.info(" Member_Controller findTraId : {} ", mVo);
			if(mVo == null) {
				rMap.put("isc", "??????");
			}else {
				rMap.put("isc", "??????");
				rMap.put("test", mVo.getId());
			}
			return rMap;
		}
		
		/* ???????????? ?????? */
		@RequestMapping(value = "/findTraPwView", method = RequestMethod.GET)
		public String findTraPw(){
			log.info("findTraPw : ???????????? ?????? ????????? ??????");
			return "findTraPw";
		}

		@GetMapping(value = "/findTraPw.do",produces = {MediaType.APPLICATION_JSON_VALUE})
		public @ResponseBody String findPw (@RequestParam Map<String, Object> map, Model model) throws Exception {
			
			String result=null;
			
			//???????????? ????????????
			MemberVo vo1 = service.findTraPw(map);
			log.info("findPw : ???????????? ???????????? ?????? ");
			
			//????????? ???????????? ??????????????? ????????? ??????
			if(vo1!=null) {
				
				//?????? ???????????? ??????(UUID??????)
				String tempPw=UUID.randomUUID().toString().replace("-", "");//-??? ??????
				tempPw = tempPw.substring(0,10);//tempPw??? ??????????????? 10?????? ?????????
				
				vo1.setPw(tempPw);//?????? ???????????? ??????
				MailUtil mail=new MailUtil(); //?????? ????????????
				mail.sendEmail(vo1);
				
				String securePw = password.encode(tempPw);//?????? ??????????????? ??????????????? vo????????? ?????? ??????
				map.put("pw", securePw);
				service.updateTraPw(map);
				result="true";

			}else {
				result="false";
			}
			return result;
		}
		
	
		

		//????????? ?????? ??????
		@RequestMapping(value = "/CheckTraId.do", method = RequestMethod.GET)
		@ResponseBody
		public int idCheck(@RequestParam("id") String id) {
			log.info("???????????? ????????? ???????????? : {} ", id);
			
			return service.checkTraId(id);
		}
		//????????? ?????? ??????
		@RequestMapping(value = "/CheckTraEmail.do", method = RequestMethod.GET)
		@ResponseBody
		public int traEmailCheck(@RequestParam("email") String email) {
			log.info("traEmailCheck ???????????? ????????? ???????????? : {} ", email);
			
			return service.checkTraEmail(email);
		}

	
	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	//????????????
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("???????????? ??????");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/duplicateLogin.do", method = RequestMethod.GET)
	public String duplicateLogin() {
		return "duplicateLogin";
	}
	
	
	@PostMapping(value="/traUploadAjaxAction.do" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 @ResponseBody
	 public ResponseEntity<FileVo> uploadFormPost(MultipartFile uploadFile) {
	
		
		 String uploadFolder = "C:\\upload\\tmp";

			String uploadFolderPath = getFolder();
		 File uploadPath = new File(uploadFolder, uploadFolderPath);
		 // make folder --------
		 log.info("upload path: " + uploadPath);
		
		 if (uploadPath.exists() == false) {
		 uploadPath.mkdirs();
		 }
		 // make yyyy/MM/dd folder
			
				FileVo fVo = new FileVo();
				MultipartFile multipartFile = uploadFile; //????????? ???????????? ????????? ?????????
				String uploadFileName = multipartFile.getOriginalFilename(); //??????????????????
			
				log.info("-------------------------------------");
				log.info("Upload File Name: " + multipartFile.getOriginalFilename());
				log.info("Upload File Size: " + multipartFile.getSize());
				
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
						log.info("only file name: " + uploadFileName);
				fVo.setOriginal_file_name(uploadFileName); //??????vo??? ?????????????????? ?????????
				 UUID uuid = UUID.randomUUID();	
				 uploadFileName = uuid.toString() + "_" + uploadFileName;
			

				try {
					File saveFile = new File(uploadPath, uploadFileName);
					multipartFile.transferTo(saveFile);
					fVo.setStored_file_name(uuid.toString());
					fVo.setFile_path(uploadFolderPath);
					 // check image type file
					 if (checkImageType(saveFile)) {
					//??????????????? ????????? ????????????, ??????????????? s_??? ???????????? ????????? ????????? ???????????? ?????? ??? ??? ??????.
						 //????????? ?????? ????????? ????????? ?????? ????????? ????????? ?????? ?????? ??? ??? ????????????.
						fVo.setFile_type(true);
					 FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" +
					 uploadFileName));
					log.info("?????????",thumbnail);
					 //?????? ???????????? ?????? ????????? ??????????????? width??? height??? ????????? ??? ????????????.
					 Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100,
					 100);
					
					 thumbnail.close();
					 }
					 
					
				} catch (Exception e) {
					log.error(e.getMessage());
				} // end catch
			 // end for
			return new ResponseEntity<>(fVo, HttpStatus.OK);
	 		}
	 //???????????? ????????? ????????????
	 private String getFolder() {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			String str = sdf.format(date);

			return str.replace("-", File.separator);
		}
	 	//?????????????????? ????????? ??????
		private boolean checkImageType(File file) {

			try {
				String contentType = Files.probeContentType(file.toPath());

				return contentType.startsWith("image");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;
		}
	 
		@GetMapping("/traDisplay.do")	
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName) {

			log.info("fileName: " + fileName);

			File file = new File("c:\\upload\\tmp\\" + fileName);
			
			log.info("file: " + file);

			ResponseEntity<byte[]> result = null;

			try {
				HttpHeaders header = new HttpHeaders();

				header.add("Content-Type", Files.probeContentType(file.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("file?????? : "+result);
			log.info("file?????? : "+result);
			return result;
		}
	
		
		@GetMapping("/traUpdateProfile.do")	
		@ResponseBody
		public ResponseEntity<byte[]> getFileName(String fileName,Authentication user,HttpSession session) throws IOException {
			Map<String, Object> map = new HashMap<String, Object>();
			log.info("fileName: " + fileName);
			   File fileput = new File(fileName);
			   map.put("profile",fileName);
			System.out.println(map);
			
			   
			   File file = new File("c:\\upload\\tmp\\" + fileName);
				
				log.info("file: " + file.toString());

				ResponseEntity<byte[]> result = null;
				try {
					HttpHeaders header = new HttpHeaders();

					header.add("Content-Type", Files.probeContentType(file.toPath()));
				
					result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("file ??? : "+result.toString());
				
				map.put("id",user.getPrincipal().toString());
			    service.updateProfile(map);
			session.invalidate();
			return result;
		}
	
		


	
	
	

}
