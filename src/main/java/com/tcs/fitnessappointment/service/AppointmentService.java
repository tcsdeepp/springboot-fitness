package com.tcs.fitnessappointment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.fitnessappointment.Appointment;
import com.tcs.fitnessappointment.IAppointmentService;
import com.tcs.fitnessappointment.repository.IAppointmentRepository;



@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	IAppointmentRepository appointmentRepository;
	@Override
	public void save(Appointment app) {
		appointmentRepository.save(app);
		System.out.println("saved");
	}
	@Override
	public Appointment view(Integer id) {
		Optional<Appointment> ap1=appointmentRepository.findById(id);
		return ap1.get();
	}
	@Override
	public Iterable<Appointment> getAll() {

		return appointmentRepository.findAll();
	}
	@Override
	public void deleteUser(Integer id) {
		Optional<Appointment> ap1=appointmentRepository.findById(id);
		
		appointmentRepository.deleteById(id);
	}
	@Override
	public void updateAppointment(Integer id, Appointment app) {
		Optional<Appointment> appoint=appointmentRepository.findById(id);
		Appointment app1= appoint.get();

		if(StringUtils.hasText(app.getName())) {
			app1.setName(app.getName());
		}


		if(StringUtils.hasText(app.getEmail()))
			app1.setEmail(app.getEmail());

		if(StringUtils.hasText(app.getAddress()))
			app1.setAddress(app.getAddress());

		if(StringUtils.hasText(app.getTraineePreference()))
			app1.setTraineePreference(app.getTraineePreference());

		if(Boolean.valueOf(app.isPhysiotherapist()))
			app1.setPhysiotherapist(app.isPhysiotherapist());

		if((Integer)app.getNoOfWeeks()!=null)
		{	
			app1.setNoOfWeeks(app.getNoOfWeeks());
			app1.setAmount(app1.getNoOfWeeks()*app1.getPackageSelected());
		}
		if((Integer)app.getPackageSelected()!=null)
		{	
			app.setPackageSelected(app.getPackageSelected());
			app1.setAmount(app1.getNoOfWeeks()*app1.getPackageSelected());
		}	

		appointmentRepository.save(app1);
	}

}