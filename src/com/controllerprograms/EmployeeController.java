package com.controllerprograms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beanprograms.EmployeeInfo;
import com.serviceprograms.EmployeeServices;

@Controller
@RequestMapping("/employees")
public class EmployeeController extends HttpServlet{

	@Autowired
	EmployeeServices empservice;
	
	@RequestMapping("/signin")
	public String signinform() {
		return "signin";
	}
	
	@RequestMapping("/fetchdetails")
	public String fetchRecords(HttpServletRequest req, Model mod) {
		String pswd = req.getParameter("pwd");
		String usnm = req.getParameter("user");
		mod.addAttribute("attribute1", usnm);
		if(pswd.equalsIgnoreCase("admin")) {
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/allrecords")
	public ModelAndView retrieveAllRecords() {
		List<EmployeeInfo> records = new ArrayList<EmployeeInfo>();
//		EmployeeInfo empinfo = empservice.retrieveRecords();
		records = empservice.retrieveRecords();
		System.out.println("Records: "+records);
		return new ModelAndView("employeerecords", "emplist1", records);
	}
}