package com.rays.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarksheetModelTest {
	public static void main(String[] args) throws Exception {
		// testadd();
		// testupdate();
		// testdelete();
		 testfindById();
		//testMeritList();
		//testsearch();

	}

	private static void testsearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model= new MarksheetModel();
		List list = new ArrayList();
		bean.setName("Kamesh");
		list= model.search(bean);
		
		Iterator it= list.iterator();
		while (it.hasNext()) {
			bean= (MarksheetBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollno());
			System.out.println(bean.getName());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getMaths());
			
		}
		
	}

	private static void testMeritList() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();
		
		List list= new ArrayList();
		list= model.MeritList(bean);
		Iterator it= list.iterator();
		
		while (it.hasNext()) {
		bean = (MarksheetBean) it.next();
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRollno());
		System.out.println(bean.getName());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getMaths());
		}
		// try {
		// model.MeritList();
		// } catch (Exception e) {
		// e.printStackTrace();
	}

	private static void testfindById() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();
		bean = model.findById(4);
		System.out.println(bean.getName());

	}

	private static void testdelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(101);

	}

	private static void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(2);
		bean.setRollno(102);
		bean.setName("Luckey");
		bean.setPhysics(70);
		bean.setChemistry(50);
		bean.setMaths(90);
		MarksheetModel model = new MarksheetModel();
		model.update(bean);
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(6);
		bean.setRollno(106);
		bean.setName("Rajat");
		bean.setPhysics(78);
		bean.setChemistry(67);
		bean.setMaths(98);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

}