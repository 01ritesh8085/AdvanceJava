package com.rays.preparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserModelTest {
	public static void main(String[] args) throws Exception    {
		
		
		//testAdd();
		testUpdate();
		//testDelet();
		//testSearch();

	}

	private static void testSearch() throws Exception {
	
		UserBean bean = new UserBean();
		
		UserModel model = new UserModel();
		
		List list = new ArrayList();
		
		bean.setFirstName("Shyam");
		bean.setLastName("Yadav");
		
		
		list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (UserBean) it.next();
			
			
			System.out.println(bean.getId());
	        System.out.println("\t" + bean.getFirstName());
	        System.out.println("\t" + bean.getLastName());
	        System.out.println("\t" + bean.getLoginId());
	        System.out.println("\t" + bean.getPassword());
	        System.out.println("\t" + bean.getDob());
	        System.out.println("\t" + bean.getGender());
		}
		
		
		
		
		
		
	}

	private static void testDelet() throws Exception  {
		UserModel model = new UserModel();
		
		model.delete(3);
		
	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		UserBean bean= new UserBean();
		bean.setId(9);
		bean.setFirstName("Kanak");
		bean.setLastName("Soni");
		bean.setLoginId("kanak@gmail.com");
		bean.setPassword("kana@##123");
		bean.setDob(sdf.parse("2004-02-01"));
		bean.setGender("Female");
		
		UserModel model= new UserModel();
		
		
		
		model.update(bean);
		
		 
		
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setId(7);
		bean.setFirstName("Kanak");
		bean.setLastName("Soni");
		bean.setLoginId("kanak@gmail.com");
		bean.setPassword("kana@123");
		bean.setDob(sdf.parse("2004-02-01"));
		bean.setGender("Female");
		
		UserModel model = new UserModel();
		
		model.add(bean);

	}

}
