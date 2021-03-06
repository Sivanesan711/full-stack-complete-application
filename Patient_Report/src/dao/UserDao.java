package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDao implements UserDaoInterface {

	@Override
	public boolean signup(User user)  {
		String sql = "insert into patient_report_user(username, pass) values(?, ?)";
		boolean result = false;
		
		try
		{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			System.out.println(ps);
			result = ps.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public boolean loginuser(User user) {
		
		boolean status = false;
		
		try
		{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from patient_report_user where username = ? and pass = ?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
}
