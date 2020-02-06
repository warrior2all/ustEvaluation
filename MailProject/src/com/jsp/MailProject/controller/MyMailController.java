package com.jsp.MailProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.MailProject.dto.MailDTO;
import com.jsp.MailProject.dto.UserDTO;
import com.jsp.MailProject.service.MyService;

@Component
@RequestMapping("/")
public class MyMailController {
	
	@Autowired
	MyService ms;
	@Autowired
   HttpSession session;
	
	@RequestMapping("/register")
	public String register(){
		return "Registration";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/compose")
	public ModelAndView composeMail() {
		
		if (session.getAttribute("email")!=null){
			return new ModelAndView( "compose","msg","compose");
			}
			else{
				return new ModelAndView("login","msg","Login First");
			}
		}
	
	@RequestMapping("/draftMail")
	public ModelAndView draft() {
		List<MailDTO> mlist=ms.draft_Mail();
		
		if (session.getAttribute("email")!=null){
			return new ModelAndView( "draft","msg",mlist);
			}
			else{
				return new ModelAndView("login","msg","Login First");
			}

	}
	
	@RequestMapping("/sentMail")
	public ModelAndView sent() {
		List<MailDTO> mlist=ms.sent_Mail();
		
		if (session.getAttribute("email")!=null){
			return new ModelAndView( "sent","msg",mlist);}
			else{
				return new ModelAndView("login","msg","Login First");
			}
	}
	
	@RequestMapping("/inboxMail")
	public ModelAndView inbox() {
		System.out.println("inside controller");
		List<MailDTO> mlist=ms.inbox_Mail();
		if (session.getAttribute("email")!=null){
		return new ModelAndView( "inbox","msg",mlist);}
		else{
			return new ModelAndView("login","msg","Login First");
		}
		
	}
	@RequestMapping("/deletemessage")
	public ModelAndView deleteMessage() {
		List<MailDTO> mlist=ms.getdeletemessage();
		if (session.getAttribute("email")!=null){
		return new ModelAndView( "delete","msg",mlist);
		}
		else{
			return new ModelAndView("login","msg","Login First");
		}
		
	}
	
	@RequestMapping("/changePass")
	public String changePass() {
		return "changePass";

	}
	@RequestMapping("/forgetPassword")
	public String forget() {
		return "forget";

	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		boolean b=ms.deleteMail(id);
		if(b){
			return new ModelAndView("home","msg","deleted message succefull");
		}else{
			return new ModelAndView("home","msg","deleted not message succefull");
		}

	}
	
	@RequestMapping(value="/SignUp",method=RequestMethod.POST)
	public ModelAndView registerMail(@ModelAttribute UserDTO user){
		System.out.println("inside controller");
		boolean b=ms.registermail(user);
		if (b) {
			return new ModelAndView("Registration","msg","registration successfull");
			
		} else {
			return new ModelAndView("Registration","msg","user already registered");

		}
		
		
	}
	
	@RequestMapping(value="/logIn",method=RequestMethod.POST)
	public ModelAndView loginMail(@ModelAttribute UserDTO user,HttpSession hn){
		System.out.println("inside controller");
		UserDTO use=ms.loginMail(user);
		if (use!=null) {
			hn.setAttribute("email", use.getEmail());
			System.out.println("login successfull ");
			return new ModelAndView("home","dto",use);
		} else {
			System.out.println("login failed");
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value="/composemail",method=RequestMethod.POST)
	public ModelAndView composeMail(HttpServletRequest req){
		System.out.println("inside controller");
		boolean b=ms.composeMail(req);
		if (b) {
			return new ModelAndView("home","msg","mail sent successfull");
		} else {
			return new ModelAndView("home","msg","mail saved as draft");
			}
	}
	
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
	public String changePass(@ModelAttribute UserDTO ui,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		ms.changePassword(ui,res,req,session);
		return "login";
	}
	
	@RequestMapping(value="/forget",method=RequestMethod.POST)
	public String forget(@ModelAttribute UserDTO ud,HttpServletResponse res,HttpSession session,HttpServletRequest req) {

		System.out.println("inside controller");
		boolean b=ms.forgetPassword(ud, res, req, session);
		if (b) {
			return "login";
		} else {
			
			return "forget";

		}
		
	}
	
	/*@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute UserDTO use,HttpServletRequest req,HttpServletResponse res,HttpSession session) {
		boolean b=ms.logoutMail(use, res, req, session);
		if (b) {
			return new ModelAndView("login","msg","logout successfull");
		} else {
			return new ModelAndView("login","msg","logout unsuccessfull");
		}
	}*/
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req)
	{
		//session=req.getSession(false);
		if (session.getAttribute("email")!=null) {
			//session.invalidate();
			session.setAttribute("email",null);
			
			return new ModelAndView("login","msg","logout success");
		}
		else{
			return new ModelAndView("login","msg","logout success");
		}
		
	}
	@RequestMapping("/viewShow")
	public ModelAndView viewSent(int id){
		System.out.println("inside controller");
		MailDTO mdto=ms.showSent(id);
		if (mdto!=null) {
			return new ModelAndView("viewsent","mdto",mdto);
		} else {
			return new ModelAndView();
			}
	}
	
	@RequestMapping(value="/inboxedit",method=RequestMethod.GET)
	public ModelAndView viewInbox(int id){
		System.out.println("inside controller");
		MailDTO mdto=ms.showinbox(id);
		if (mdto!=null) {
			return new ModelAndView("inboxMail","mdto",mdto);
		} else {
			return new ModelAndView();
			}
	}
	
	@RequestMapping("/editDraft")
	public ModelAndView editcomp(@RequestParam int id){
		MailDTO dto=ms.composedraft(id);System.out.println(dto.getDraft_message());
		return new ModelAndView("editDraft","dto",dto);
	}
	
	@RequestMapping(value="/editcompose", method=RequestMethod.POST)
	public ModelAndView editcomposeMail(HttpServletRequest req){
		System.out.println("inside controller");
		boolean b=ms.editcompose(req);
		if (b) {
			return new ModelAndView("home","msg","mail sent successfull");
		} else {
			return new ModelAndView("home","msg","mail saved as draft");
			}
	}

}
