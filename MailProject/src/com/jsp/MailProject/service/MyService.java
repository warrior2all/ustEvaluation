package com.jsp.MailProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.jsp.MailProject.dto.MailDTO;
import com.jsp.MailProject.dto.UserDTO;

public interface MyService {
	public boolean registermail(UserDTO user);
	public UserDTO loginMail(UserDTO user);
	public boolean composeMail(HttpServletRequest req);
	public boolean changePassword(UserDTO user,HttpServletResponse resp,HttpServletRequest req,HttpSession session);
	//public boolean logoutMail(UserDTO user,HttpServletResponse resp,HttpServletRequest req,HttpSession session);
	public boolean forgetPassword(UserDTO user,HttpServletResponse resp,HttpServletRequest req,HttpSession session);
	public boolean deleteMail(int id);
	List<MailDTO> draft_Mail();
	List<MailDTO> sent_Mail();
	List<MailDTO> inbox_Mail();
	public List<MailDTO> getdeletemessage();
	public MailDTO showinbox(int id);
	public MailDTO showSent(int id);
	public boolean editcompose(HttpServletRequest req);
	public MailDTO composedraft(int id);
}
