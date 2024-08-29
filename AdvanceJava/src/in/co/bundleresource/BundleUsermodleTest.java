package in.co.bundleresource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.preparedStatement.UserBean;
import com.rays.preparedStatement.UserModel;

public class BundleUsermodleTest {


	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
		 testSearch();
		//testFindByLogin();

	}

	private static void testFindByLogin() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		bean = model.findByLoginId("naman@gmail.com");

		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());

	}

	private static void testSearch() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = new ArrayList();

		bean.setFirstName("Naman");
		bean.setLastName("Malwiya");

		list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getGender());

		}

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(3);

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Kanak");
		bean.setLastName("Soni");
		bean.setLoginId("kanak123@gmail.com");
		bean.setPassword("kanak@#123");
		bean.setDob(sdf.parse("2004-02-01"));
		bean.setGender("Female");

		UserModel model = new UserModel();

		model.update(bean);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		bean.setFirstName("Mayank");
		bean.setLastName("Choudhary");
		bean.setLoginId("montu123@gmail.com");
		bean.setPassword("montu@123");
		bean.setDob(sdf.parse("2004-02-01"));
		bean.setGender("Male");

		UserModel model = new UserModel();

		model.add(bean);

	}

}
