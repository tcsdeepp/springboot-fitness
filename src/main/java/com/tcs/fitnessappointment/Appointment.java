package com.tcs.fitnessappointment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

@Entity(name = "Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointment_id;
	
	@NotNull(message="Please enter name")
	private String name;
	@NotNull(message="Please enter Email")
	@Email(message="Please enter correct Email")
	private String email;
	@NotEmpty(message="Please enter address")
	private String address;
	@NotEmpty(message="Please enter Trainer Preference")
	private String traineePreference;
	@Value("${some.key:false}")
	private boolean physiotherapist;
	@Min(300)
	@Max(500)
	private int packageSelected;
	@NotEmpty(message="Please enter no of weeks")
	private int noOfWeeks;
	private Long number;
	private int amount= packageSelected*noOfWeeks;
	
	
	public Integer getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTraineePreference() {
		return traineePreference;
	}
	public void setTraineePreference(String traineePreference) {
		this.traineePreference = traineePreference;
	}
	public boolean isPhysiotherapist() {
		return physiotherapist;
	}
	public void setPhysiotherapist(boolean physiotherapist) {
		this.physiotherapist = physiotherapist;
	}
	public int getPackageSelected() {
		return packageSelected;
	}
	public void setPackageSelected(int packageSelected) {
		this.packageSelected = packageSelected;
	}
	public int getNoOfWeeks() {
		return noOfWeeks;
	}
	public void setNoOfWeeks(int noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", name=" + name + ", email=" + email + ", address="
				+ address + ", traineePreference=" + traineePreference + ", physiotherapist=" + physiotherapist
				+ ", packageSelected=" + packageSelected + ", noOfWeeks=" + noOfWeeks + ", number=" + number
				+ ", amount=" + amount + "]";
	}
}


