package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ICU;

public interface ICUDao {
	public boolean insertICU(ICU newICU) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteICU(int icuId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateICU(int icuId, ICU renewICU) throws ClassNotFoundException, SQLException, IOException;
	public ICU displayICU(int icuId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<ICU> displayAllICUs() throws ClassNotFoundException, SQLException, IOException;
}
