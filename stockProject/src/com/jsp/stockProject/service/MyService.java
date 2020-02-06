package com.jsp.stockProject.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.jsp.stockProject.dto.ModelDTO;
import com.jsp.stockProject.dto.OrderDTO;
import com.jsp.stockProject.dto.RegistrationDTO;
public interface MyService {
	
	boolean MangerRegistration(RegistrationDTO rdto);
    boolean ManagerLogin(HttpServletRequest req);
    boolean addproduct(ModelDTO mdto);
    public List<ModelDTO> allproduct();
    List<ModelDTO> searchproduct(String search,String filter);
    List<ModelDTO> updateproduct(ModelDTO mdto);
    List<ModelDTO> addtocart(ModelDTO mdto);
    List<ModelDTO> cartadded(ModelDTO mdto);
    List<OrderDTO> showCart();

}
