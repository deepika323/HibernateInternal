package model.dao;

import static model.helper.ConnectToDb.closeConnection;
import static model.helper.ConnectToDb.openConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Appointment;

public class AppointmentDaoImpl implements AppointmentDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertAppointment(Appointment newAppointment) throws ClassNotFoundException,SQLException, IOException{
		// TODO Auto-generated method stub
        con= openConnection();
		
		int regNo=newAppointment.getRegNo();
		String personId=newAppointment.getPersonId();
		String purpose=newAppointment.getPurpose();
		float payment=newAppointment.getPayment();
		String doctorId=newAppointment.getDoctorId();
		Date appointmentDate=newAppointment.getAppointmentDate();
		
		pstmt=con.prepareStatement("insert into Appointment(regNo,personId," +
				"purpose,payment,doctorId,regDate) values " + 
				"(?,?,?,?,?,?)");
		
		pstmt.setInt(1,regNo);
		pstmt.setString(2,personId );
		pstmt.setString(3, purpose);
		pstmt.setFloat(4, payment);
		pstmt.setString(5, doctorId);
		pstmt.setDate(6, appointmentDate);
		
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else closeConnection(con);
		return false;
	}

	@Override
	public boolean deleteAppointment(int regNo) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
        con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from Appointment where regNo = ?");
		
		pstmt.setInt(1,regNo);
		
		int rows=pstmt.executeUpdate();
		
		if(rows>0)
		{
			closeConnection(con);
			return true;
		}
		else 
		{
			closeConnection(con);
			return false;
		}
	}

	@Override
	public boolean updateAppointment(int regNo, Appointment renewAppointment) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
		   con= openConnection();
			
			
			pstmt=con.prepareStatement("update Appointment set  personId =? "
					+ ", purpose=? ,payment=? ,doctorId=? ,regDate=? where regNo = ?  ");
			

			pstmt.setInt(6,regNo);
			pstmt.setString(1,renewAppointment.getPersonId());
			pstmt.setString(2, renewAppointment.getPurpose());
			pstmt.setFloat(3, renewAppointment.getPayment());
			pstmt.setString(4, renewAppointment.getDoctorId());
			pstmt.setDate(5, renewAppointment.getAppointmentDate());
			
			int rows=pstmt.executeUpdate();
			
			if(rows>0)
			{
				closeConnection(con);
				return true;
			}
			else 
				{
				closeConnection(con);
				return false;
				}

	}

	@Override
	public Appointment displayAppointment(int regNo) throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from Appointment where regNo = ?");
		pstmt.setInt(1,regNo);
		
		rs=pstmt.executeQuery();
		
		Appointment appointment=new Appointment();
		while(rs.next())
		{
			appointment.setRegNo(rs.getInt("regNo"));
			appointment.setPersonId(rs.getString("personId"));
			appointment.setPurpose(rs.getString("purpose"));
			appointment.setPayment(rs.getFloat("payment"));
			appointment.setDoctorId(rs.getString("doctorId"));
			appointment.setAppointmentDate(rs.getDate("regDate"));
			
		}
		
		closeConnection(con);
		return appointment;
	}

	@Override
	public ArrayList<Appointment> displayAllAppointments() throws ClassNotFoundException,SQLException, IOException {
		// TODO Auto-generated method stub
		 con= openConnection();
			
			
			pstmt=con.prepareStatement("select * from appointment ");
			
			
			rs=pstmt.executeQuery();
			
			ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
			
			
			while(rs.next())
			{
				Appointment appointment=new Appointment();
				appointment.setRegNo(rs.getInt("regNo"));
				appointment.setPersonId(rs.getString("personId"));
				appointment.setPurpose(rs.getString("purpose"));
				appointment.setPayment(rs.getFloat("payment"));
				appointment.setDoctorId(rs.getString("doctorId"));
				appointment.setAppointmentDate(rs.getDate("regDate"));
				
				//System.out.println(appointment);
				
				//System.out.println(appointment);
				appointmentList.add(appointment);
			}
			
		//	System.out.println(appointmentList);
			closeConnection(con);
			//System.out.println(appointmentList);
			//System.out.println();
			//System.out.println();

			return appointmentList;
	}

}
