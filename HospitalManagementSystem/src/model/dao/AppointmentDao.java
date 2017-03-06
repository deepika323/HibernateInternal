package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Appointment;

public interface AppointmentDao {
	public boolean insertAppointment(Appointment newAppointment) throws ClassNotFoundException,SQLException, IOException;
	public boolean deleteAppointment(int appointmentId) throws ClassNotFoundException,SQLException, IOException;
	public boolean updateAppointment(int appointmentId, Appointment renewAppointment) throws ClassNotFoundException,SQLException, IOException;
	public Appointment displayAppointment(int appointmentId) throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<Appointment> displayAllAppointments() throws ClassNotFoundException,SQLException, IOException;
}
