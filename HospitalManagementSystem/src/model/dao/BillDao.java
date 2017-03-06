package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Bill;

public interface BillDao {
	public boolean insertBill(Bill newBill) throws ClassNotFoundException, SQLException, IOException;
	public boolean deleteBill(int billId) throws ClassNotFoundException, SQLException, IOException;
	public boolean updateBill(int billId, Bill renewBill) throws ClassNotFoundException, SQLException, IOException;
	public Bill displayBill(int billId) throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Bill> displayAllBills() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Bill> displayMyBills(String personId) throws ClassNotFoundException, SQLException, IOException;
}
