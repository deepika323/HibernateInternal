package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.OT;

public interface OTDao {
	public boolean insertOT(OT newOT) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteOT(int otId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateOT(int otId, OT renewOT) throws ClassNotFoundException, SQLException, IOException;
	public OT displayOT(int otId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<OT> displayAllOTs() throws ClassNotFoundException, SQLException, IOException;
}

