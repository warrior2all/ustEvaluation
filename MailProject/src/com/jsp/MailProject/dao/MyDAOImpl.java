package com.jsp.MailProject.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.MailProject.dto.MailDTO;
import com.jsp.MailProject.dto.UserDTO;
@Component
public class MyDAOImpl implements MyDAO {
	@Autowired
	SessionFactory sf;
	@Autowired
	HttpSession hn;

	@Override
	public boolean registermail(UserDTO user) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr =ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", user.getEmail()));
		cr.add(Restrictions.eq("username", user.getUsername()));
		UserDTO dto=(UserDTO) cr.uniqueResult();
		if (dto!=null) {
			return false;
			
		} else {
			ss.save(user);
			ss.beginTransaction().commit();
			ss.close();
			return true;}
	}

	@Override
	public UserDTO loginMail(UserDTO user) {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserDTO.class);
	cr.add(Restrictions.eq("username", user.getUsername()));
	cr.add(Restrictions.eq("password", user.getPassword()));
	UserDTO udto=(UserDTO) cr.uniqueResult();
		
		ss.close();
		return udto;
	}

	@Override
	public boolean composeMail(HttpServletRequest req) {
		// TODO Auto-generated method stub
		Session ss= sf.openSession();
		String to=req.getParameter("to");
		String msg=req.getParameter("msg");
		this.hn=req.getSession();
		String from_id=(String)hn.getAttribute("email");
		MailDTO mdto=null;
		Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email",to));
		UserDTO udto=(UserDTO)cr.uniqueResult();
		if (udto!=null){
			mdto=new MailDTO();
			mdto.setInbox(msg);
			mdto.setSent(to);
			mdto.setFrom_id(from_id);
			Criteria cr1=ss.createCriteria(UserDTO.class);
			cr1.add(Restrictions.eq("email",from_id));
			UserDTO ud=(UserDTO)cr1.uniqueResult();
			List<MailDTO> mlist=ud.getMlist();
			mlist.add(mdto);
			ss.saveOrUpdate(ud);
			ss.beginTransaction().commit();
//			mdto.setMailStatus("sent");
//			ss.saveOrUpdate(mdto);
//			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			mdto=new MailDTO();
			mdto.setDraft(to);
			mdto.setDraft_message(msg);
			mdto.setFrom_id(from_id);
			Criteria cr1=ss.createCriteria(UserDTO.class);
			cr1.add(Restrictions.eq("email",from_id));
			UserDTO ud=(UserDTO)cr1.uniqueResult();
			List<MailDTO> mlist=ud.getMlist();
			mlist.add(mdto);
			ss.saveOrUpdate(ud);
			ss.beginTransaction().commit();
//			mdto.setMailStatus("draft");
//			ss.saveOrUpdate(mdto);
//			ss.beginTransaction().commit();
			ss.close();
			return false;

		}
	}

	@Override
	public boolean changePassword(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String oldpass=req.getParameter("oldpassword");
		String newpass=req.getParameter("newpassword");
		
		Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("password", oldpass));
		UserDTO udto=(UserDTO) cr.uniqueResult();
		if(udto!=null){
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else{
			return false;
		}
	}
/*
	@Override
	public boolean logoutMail(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		session=req.getSession(false);
		if (session.getAttribute("email")!=null) {
			session.invalidate();
			return true;
		} else {
			return false;
			}
	}*/

	@Override
	public boolean forgetPassword(UserDTO user, HttpServletResponse resp, HttpServletRequest req, HttpSession session) {
		Session ss=sf.openSession();
		String email=req.getParameter("email");
		String question=req.getParameter("question");
		String answer=req.getParameter("answer");
		String newpass=req.getParameter("newpassword");
	    Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("question",question));
		cr.add(Restrictions.eq("answer",answer));
		UserDTO udto=(UserDTO) cr.uniqueResult();
		if(udto!=null){
			udto.setPassword(newpass);
			ss.saveOrUpdate(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean deleteMail(int id) {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		cr.add(Restrictions.eq("mid", id));
		MailDTO md=(MailDTO) cr.uniqueResult();
		if(md!=null){
			md.setMailStatus("deleted");
			ss.saveOrUpdate(md);
			ss.beginTransaction().commit();
			ss.close();
			return true;
			
			
		}else{
		return false;
		}
	}

	@Override
	public List<MailDTO> draft_Mail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("from_id", sentby));
		System.out.println("my email  "+sentby);
		cr.add(Restrictions.isNull("sent"));
		cr.add(Restrictions.isNotNull("draft"));
		cr.add(Restrictions.isNotNull("draft_message"));
		//cr.add(Restrictions.eq("mailStatus","draft"));
//		User_Info uin=(User_Info) cr.uniqueResult();
		//cr.add(Restrictions.eq("mailStatus", "draft"));
		List<MailDTO> mlist=cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<MailDTO> sent_Mail() {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("from_id", sentby));
		cr.add(Restrictions.isNotNull("sent"));
		cr.add(Restrictions.isNull("draft"));
		cr.add(Restrictions.isNull("draft_message"));
		cr.add(Restrictions.isNull("mailStatus"));
		//cr.add(Restrictions.eq("mailStatus","sent"));
	   // cr.add(Restrictions.isNull("mailStatus"));
		List<MailDTO> mlist=cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<MailDTO> inbox_Mail() {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		String sentby=(String) hn.getAttribute("email");
		Criteria cr=ss.createCriteria(MailDTO.class);
		//cr.add(Restrictions.isNotNull("sent"));
		cr.add(Restrictions.eq("sent", sentby));
		cr.add(Restrictions.isNull("mailStatus"));
		cr.add(Restrictions.isNull("draft"));
		List<MailDTO> mlist=cr.list();
		ss.close();
		
		return mlist;
	}

	@Override
	public List<MailDTO> getdeletemessage() {
		System.out.println("inside dao");
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		String sentby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("from_id", sentby));
		cr.add(Restrictions.eq("mailStatus", "deleted"));
		//cr.add(Restrictions.eq("sent", sentby));
		List<MailDTO> mlist=cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public MailDTO showinbox(int id) {
		// TODO Auto-generated method stub
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		cr.add(Restrictions.eq("mid",id));
		
		MailDTO mdto=(MailDTO)cr.uniqueResult();
		ss.close();
		return mdto;
	}

	@Override
	public MailDTO showSent(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		cr.add(Restrictions.eq("mid",id));
		MailDTO mdto=(MailDTO)cr.uniqueResult();
		ss.close();
		return mdto;
	}

	@Override
	public boolean editcompose( HttpServletRequest req) {
		Session ss=sf.openSession();
		String to=req.getParameter("to");
		String smid=req.getParameter("id");
		int  mid=Integer.parseInt(smid);
		String msg=req.getParameter("msg");
		this.hn=req.getSession();
		String sentby=(String) hn.getAttribute("email");
		
		MailDTO min=null;
		Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("email", to));
		UserDTO uinf=(UserDTO)cr.uniqueResult();
		MailDTO mdto=ss.load(MailDTO.class, mid);
		if(uinf!=null){
			
			mdto.setInbox(msg);
			mdto.setSent(to);
			mdto.setFrom_id(sentby);
			 mdto.setDraft(null);
			// mdto.setMailStatus("sent");
			 
			 List<MailDTO> mlist1=uinf.getMlist();
			 mlist1.add(mdto);
			 ss.update(uinf);
			 ss.beginTransaction().commit();
			 ss.close();
			return true;
			
		}else{
			mdto.setInbox(msg);
			mdto.setSent(to);
			mdto.setFrom_id(sentby);
			 mdto.setDraft(msg);
			// mdto.setMailStatus("draft");
			 Criteria cr1=ss.createCriteria(UserDTO.class);
			 cr1.add(Restrictions.eq("email", sentby));
			 UserDTO uin=(UserDTO) cr1.uniqueResult();
			 List<MailDTO> mlist=uin.getMlist();
			 mlist.add(min);
			 ss.saveOrUpdate(uin);
			 ss.beginTransaction().commit();
			 ss.close();
			 return false;
			 }
		
		}

	@Override
	public MailDTO composedraft(int id) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(MailDTO.class);
		cr.add(Restrictions.eq("mid", id));
		MailDTO mdto=(MailDTO)cr.uniqueResult();
		ss.close();
		return mdto;
	}

}
