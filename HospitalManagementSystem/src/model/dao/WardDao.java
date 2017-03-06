package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Ward;

public interface WardDao {
	public boolean insertWard(Ward newWard) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteWard(int bedNo) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateWard(int bedNo, Ward renewWard) throws ClassNotFoundException, SQLException, IOException;
	public Ward displayWard(int bedNo) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Ward> displayAllWards() throws ClassNotFoundException, SQLException, IOException;
	//test
}
