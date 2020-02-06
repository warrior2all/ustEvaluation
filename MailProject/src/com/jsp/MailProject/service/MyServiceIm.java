package com.jsp.MailProject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.MailProject.dao.MyDAO;
import com.jsp.MailProject.dto.MailDTO;
import com.jsp.MailProject.dto.UserDTO;

@Component
public class MyServiceIm implements MyService{
	@Autowired
	MyDAO md;

	@Override
	public boolean registermail(UserDTO user) {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		boolean b=md.registermail(user);
		return b;
	}

	@Override
	public UserDTO loginMail(UserDTO user) {
		// TODO Auto-generated method stub
		System.out.println("inside service");
		UserDTO ud=md.loginMail(user);
	    return ud;
	}

	@Override
	public boolean composeMail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.composeMail(req);
	}

	@Override
	public boolean changePassword(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		md.changePassword(user, resp, req, session);
		return false;
	}

	/*@Override
	public boolean logoutMail(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		boolean b =md.logoutMail(user, resp, req, session);
		if (b) {
			return  true;
			
		} else {
			return false;

		}
	}*/

	@Override
	public boolean forgetPassword(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		return md.forgetPassword(user, resp, req, session);
	}

	@Override
	public boolean deleteMail(int id) {
		// TODO Auto-generated method stub
		boolean b=md.deleteMail(id);
		return b;
	}

	@Override
	public List<MailDTO> draft_Mail() {
		// TODO Auto-generated method stub
		List<MailDTO> mlist=md.draft_Mail();
		return mlist;
	}

	@Override
	public List<MailDTO> sent_Mail() {
		// TODO Auto-generated method stub
		List<MailDTO> mlist=md.sent_Mail();
		return mlist;
	}

	@Override
	public List<MailDTO> inbox_Mail() {
		// TODO Auto-generated method stub
		System.out.println("inside service inbx");
		List<MailDTO> mlist=md.inbox_Mail();
		return mlist;
	}

	@Override
	public List<MailDTO> getdeletemessage() {
		// TODO Auto-generated method stub
		List<MailDTO> mlist=md.getdeletemessage();
		return mlist;
	}

	@Override
	public MailDTO showinbox(int id) {
		// TODO Auto-generated method stub
		MailDTO mdt=md.showinbox(id);
		return mdt;
	}

	@Override
	public MailDTO showSent(int id) {
		// TODO Auto-generated method stub
		MailDTO mdt=md.showSent(id);
		return mdt;
	}

	@Override
	public boolean editcompose(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return md.editcompose(req);
	}

	@Override
	public MailDTO composedraft(int id) {
		// TODO Auto-generated method stub
		return md.composedraft(id);
	}

}
