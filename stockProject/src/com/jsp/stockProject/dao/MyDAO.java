package com.jsp.stockProject.dao;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.jsp.stockProject.dto.ModelDTO;
import com.jsp.stockProject.dto.OrderDTO;
import com.jsp.stockProject.dto.RegistrationDTO;
@Component
public interface MyDAO {


	boolean MangerRegistration(RegistrationDTO rdto);

	boolean ManagerLogin(HttpServletRequest req);

	boolean addproduct(ModelDTO mdto);

	List<ModelDTO> allproduct();
	
	List<ModelDTO> searchproduct(String search, String filter);

	List<ModelDTO> updateproduct(ModelDTO mdto);

	List<ModelDTO> addtocart(ModelDTO mdto);

	List<ModelDTO> cartadded(ModelDTO mdto);
	List<OrderDTO> showCart();
}
