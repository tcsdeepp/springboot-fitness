package com.tcs.fitnessappointment;

import com.tcs.fitnessappointment.Appointment;

public interface IAppointmentService {
	void save(Appointment app);
	Appointment view(Integer id);
	Iterable<Appointment> getAll();
	void deleteUser(Integer id);
	void updateAppointment(Integer id, Appointment app);
}