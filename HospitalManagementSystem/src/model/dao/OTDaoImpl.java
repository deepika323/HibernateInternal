package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import static model.helper.ConnectToDb.*;

import model.bean.OT;

public class OTDaoImpl implements OTDao {
	
	private PreparedStatement pstmt=null;
	private Connection con;
	private ResultSet rs;

	@Override
	public boolean insertOT(OT newOT) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection(); 
		
		int otId = newOT.getOtId();
		String description = newOT.getDescription();
		String equipments = newOT.getEquipments();
		int patientId = newOT.getPatientId();
		int staffId = newOT.getStaffId();
		String doctorId = newOT.getDoctorId();
		
		pstmt=con.prepareStatement("insert into ot (otId,description,equipments,patientId,staffId,doctorId)"
				+ "values" + "(?,?,?,?,?,?)");
		
		pstmt.setInt(1,otId);
		pstmt.setString(2, description);
		pstmt.setString(3, equipments);
		pstmt.setInt(4,patientId);
		pstmt.setInt(5,staffId);
		pstmt.setString(6,doctorId);
		
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
	public boolean deleteOT(int otId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("delete from ot where otId = ?");
		
		pstmt.setInt(1,otId);
		
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
	public boolean updateOT(int otId, OT renewOT) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("update ot set description = ? , equipments = ? "
				+ ", patientId = ? ,staffId = ? "
				+ ", doctorId= ? "
				+ "where otId = ?");
		

		pstmt.setInt(6,otId);
		pstmt.setString(1,renewOT.getDescription());
		pstmt.setString(2, renewOT.getEquipments());
		pstmt.setInt(3, renewOT.getPatientId());
		pstmt.setInt(4, renewOT.getStaffId());
		pstmt.setString(5, renewOT.getDoctorId());
		
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
	public OT displayOT(int otId) throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ot where otId = ?");
		pstmt.setInt(1,otId);
		
		rs=pstmt.executeQuery();
		
		OT ot=new OT();
		while(rs.next())
		{
			ot.setOtId(rs.getInt("otId"));
			ot.setDescription(rs.getString("description"));
			ot.setEquipments(rs.getString("equipments"));
			ot.setPatientId(rs.getInt("patientId"));
		    ot.setStaffId(rs.getInt("staffId"));
			ot.setDoctorId(rs.getString("doctorId"));
		}
		
		closeConnection(con);
		return ot;
	}

	@Override
	public ArrayList<OT> displayAllOTs() throws ClassNotFoundException, SQLException, IOException {
		con= openConnection();
		
		
		pstmt=con.prepareStatement("select * from ot ");
		
		
		rs=pstmt.executeQuery();
		
		ArrayList<OT> otList=new ArrayList<OT>();
		
		
		while(rs.next())
		{
			OT ot=new OT();
			ot.setOtId(rs.getInt("otId"));
			ot.setDescription(rs.getString("description"));
			ot.setEquipments(rs.getString("equipments"));
			ot.setPatientId(rs.getInt("patientId"));
		    ot.setStaffId(rs.getInt("staffId"));
			ot.setDoctorId(rs.getString("doctorId"));
		}
		
		closeConnection(con);

		return otList;
	}

}
