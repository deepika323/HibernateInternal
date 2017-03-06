package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DischargeSummary;

public interface DischargeSummaryDao {
	public boolean insertDischargeSummary(DischargeSummary newDischargeSummary) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteDischargeSummary(int dischargeSummaryId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateDischargeSummary(int dischargeSummaryId, DischargeSummary renewDischargeSummary) throws ClassNotFoundException, SQLException, IOException;
	public DischargeSummary displayDischargeSummary(int dischargeSummaryId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<DischargeSummary> displayAllDischargeSummarys() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<DischargeSummary> displayMyDischargeSummarys(String personId)
			throws ClassNotFoundException, SQLException, IOException;
}
