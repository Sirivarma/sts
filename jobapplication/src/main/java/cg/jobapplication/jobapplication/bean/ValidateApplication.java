package cg.jobapplication.jobapplication.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class ValidateApplication {
	
	@Id
	private int applicationId;
	
	@Size(min=3,max=25, message="name should be minimum of 3 Characters")
	@Pattern(regexp="^[a-z A-Z]*$",message="a-z and A-Zare allowed")
	private String ApplicantName;
	
	
	private String status;


	public int getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}


	public String getApplicantName() {
		return ApplicantName;
	}


	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public ValidateApplication() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ValidateApplication(int applicationId, String applicantName, String status) {
		super();
		this.applicationId = applicationId;
		ApplicantName = applicantName;
		this.status = status;
	}


	@Override
	public String toString() {
		return "ValidateApplication [applicationId=" + applicationId + ", ApplicantName=" + ApplicantName + ", status="
				+ status + "]";
	}
	
	

}
