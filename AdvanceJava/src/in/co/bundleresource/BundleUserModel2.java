package in.co.bundleresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.preparedStatement.UserBean;


	public class BundleUserModel2 {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.system");

		public int nextPk() throws Exception {

			int pk = 0;

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from users");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				pk = rs.getInt(1);

				System.out.println("max id = " + pk);

			}
			return pk + 1;
		}

		public void add(UserBean bean) throws Exception {

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			UserBean existBean = findByLoginId(bean.getLoginId());

			if (existBean != null) {

				System.out.println("LoginId already exist plead use diffrent Email");

			} else {
				PreparedStatement pstmt = conn.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");

				pstmt.setInt(1, nextPk());
				pstmt.setString(2, bean.getFirstName());
				pstmt.setString(3, bean.getLastName());
				pstmt.setString(4, bean.getLoginId());
				pstmt.setString(5, bean.getPassword());
				pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
				pstmt.setString(7, bean.getGender());

				int i = pstmt.executeUpdate();

				System.out.println("data inserted successfully.. " + i);
			}

		}

		public void update(UserBean bean) throws Exception {

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			PreparedStatement pstmt = conn.prepareStatement(
					"update users set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ?, gender = ? where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLoginId());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getGender());
			pstmt.setInt(7, bean.getId());

			int i = pstmt.executeUpdate();

			System.out.println("Update successfully.. " + i);

		}

		public void delete(int i) throws Exception {

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			PreparedStatement pstmt = conn.prepareStatement("delete from users where id = ?");

			pstmt.setInt(1, i);

			int a = pstmt.executeUpdate();

			System.out.println("Data deleted successfully.. " + a);

		}

		public UserBean findByLoginId(String loginId) throws Exception {

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			PreparedStatement pstmt = conn.prepareStatement("select * from users where loginId = ?");

			pstmt.setString(1, loginId);

			ResultSet rs = pstmt.executeQuery();

			UserBean bean = null;

			while (rs.next()) {

				bean = new UserBean();

				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setGender(rs.getString(7));

			}
			return bean;
		}

		public List search(UserBean bean) throws Exception {

			Class.forName(rb.getString("driver"));

			Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
					rb.getString("password"));

			StringBuffer sql = new StringBuffer("select * from users where 1=1");

			if (bean != null) {

				if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

					sql.append(" and firstName like '" + bean.getFirstName() + "'");

				}

				if (bean.getLastName() != null && bean.getLastName().length() > 0) {

					sql.append(" and lastName like '" + bean.getLastName() + "'");

				}

			}

			System.out.println("sql query ==== > " + sql.toString());

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			List list = new ArrayList();

			while (rs.next()) {

				bean = new UserBean();

				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLoginId(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setGender(rs.getString(7));

				list.add(bean);

			}
			return list;

		}

	}


