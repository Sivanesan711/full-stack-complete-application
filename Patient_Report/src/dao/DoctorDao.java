package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Doctor;
import utility.ConnectionManager;

public class DoctorDao implements DoctorDaoInterface {

	@Override
	public boolean loginuser(Doctor doctor) {
		boolean status = false;
		
		try
		{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from patient_report_user where username = ? and pass = ?");
			ps.setString(1, doctor.getEmail());
			ps.setString(2, doctor.getPassword());
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
