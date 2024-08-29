package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.rays.preparedStatement.UserBean;

public class MarksheetModel {
	


	ResourceBundle rb= ResourceBundle.getBundle("com.rays.bundle.system");
	
	public void add(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		
		PreparedStatement pstmt= conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");
		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());
		
		int i= pstmt.executeUpdate();
		System.out.println("done"+ i);

	}
	
	public void update(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		
		PreparedStatement pstmt= conn.prepareStatement("update marksheet set rollno=?, name=?, physics=?, chemistry=?, maths=? where id= ?");
		
		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName() );
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());
		
		int i= pstmt.executeUpdate();
		System.out.println("Update done"+ i);
			
	}
	
	public void delete(int i) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		PreparedStatement pstmt= conn.prepareStatement("delete from marksheet where rollno=?");
		
		pstmt.setInt(1, i);
		int a= pstmt.executeUpdate();
		System.out.println("delete done");
		
	}
	
	public MarksheetBean findById(int id) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		PreparedStatement pstmt= conn.prepareStatement("select * from marksheet where id=?");
		pstmt.setInt(1, id);
		ResultSet rs= pstmt.executeQuery();
		
		System.out.println("find done"+ rs);
		
		MarksheetBean bean= null;
		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		
	}
	return bean;
}
	
	public List MeritList(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		PreparedStatement pstmt= conn.prepareStatement("select *, (physics+chemistry+maths) as total,((physics+chemistry+maths)/3) as percentage from marksheet order by total desc limit 0,3");
		ResultSet rs= pstmt.executeQuery();
		
		
		System.out.println("toppers are"+ rs);	
	
	List list = new ArrayList();
	
	
	while (rs.next()) {
		bean= new MarksheetBean();
		bean.setId(rs.getInt(1));
		bean.setName(rs.getString(3));
		bean.setRollno(rs.getInt(2));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
		list.add(bean);
			
	}
	return list;	
	}

	
	public List search(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn= DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
		StringBuffer sql= new StringBuffer("select * from marksheet  where 1=1");
		
		if(bean!= null) {
			if(bean.getName()!= null && bean.getName().length()>0) {
				sql.append(" and Name like '" + bean.getName() + "'");
					
			}
			System.out.println(sql.toString());
		}
			
			
			PreparedStatement pstmt= conn.prepareStatement(sql.toString());
			ResultSet rs= pstmt.executeQuery();
			List list= new ArrayList();
			
			while (rs.next()) {
				bean= new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setRollno(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				
				list.add(bean);
			}	
	
		return list;
	
	}

}