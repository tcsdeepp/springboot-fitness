//package com.tcs.fitnessappointment;
package com.tcs.fitnessappointment.repository;
import org.springframework.data.repository.CrudRepository;
import com.tcs.fitnessappointment.Appointment;
public interface IAppointmentRepository extends CrudRepository<Appointment, Integer>{

}
