package com.serviceprograms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beanprograms.EmployeeInfo;
import com.daoprograms.EmployeeDao;

@Service
public class EmployeeServices {

	@Autowired
	EmployeeDao empdao;
	
	public List<EmployeeInfo> retrieveRecords() {
		EmployeeInfo emp = null;
		List<EmployeeInfo> list = new ArrayList<EmployeeInfo>();
		try {
//			emp = empdao.getAll();
			list = empdao.getAll();
			System.out.println(list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
