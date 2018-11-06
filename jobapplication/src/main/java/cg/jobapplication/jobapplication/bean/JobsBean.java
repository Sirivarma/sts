package cg.jobapplication.jobapplication.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class JobsBean {
@Id
@GeneratedValue
	private int jobId;
	
	@Size(min=2, max=50, message="minimun 3 characters Required")
	@Pattern(regexp="^[a-z A-Z]*$",message="a-z and A-Zare allowed")
	private String JobTitle;
	
	@Size(min=2, max=50, message="Qualification Required")
	@Pattern(regexp="^[a-z A-Z,.]*$",message="a-z,A-Z and , are allowed")
	private String qualification;
	
	
	

	
	@Size(min=2, max=50, message="minimun 3 characters Required")
	@Pattern(regexp="^[a-z A-Z,]*$",message="a-z,A-Z and , are allowed")
	private String jobLocation;
	
	@Size(min=2, max=50, message="minimun 3 characters Required")
	@Pattern(regexp="^[a-z A-Z,]*$",message="a-z,A-Z and , are allowed")
	private String organizationName;
	
	@Size(min=2, max=50, message="minimun 3 characters Required")
	@Pattern(regexp="^[a-z A-Z,.()]*$",message="a-z,A-Z,(,) and , are allowed")
	private String jobDescription;
	
	@Size(min=2, max=50, message="minimun 1 characters Required")
	//@Pattern(regexp="^[0-9-]*$",message="0-9and - are allowed")
	private String experience;
	@NotNull(message="cannot be empty")
	//@Range(min = (long) 10.0, message="salary should be high")
	private double jobSalary;
	
	@NotNull(message="cannot be empty")
	private Integer numberOfVaccency;
	
	/**
	 * @return the jobSalary
	 */
	public double getJobSalary() {
		return jobSalary;
	}
	/**
	 * @param jobSalary the jobSalary to set
	 */
	public void setJobSalary(double jobSalary) {
		this.jobSalary = jobSalary;
	}
	
	/**
	 * @return the jobId
	 */
	@Id
	@GeneratedValue
	public int getJobId() {
		return jobId;
	}
	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return JobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	/**
	 * @return the startDate
	 */
	
	/**
	 * @return the ageLimit
	 */
	
	/**
	 * @param ageLimit the ageLimit to set
	 */

	/**
	 * @return the jobLocation
	 */
	public String getJobLocation() {
		return jobLocation;
	}
	/**
	 * @param jobLocation the jobLocation to set
	 */
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public Integer getNumberOfVaccency() {
		return numberOfVaccency;
	}
	public void setNumberOfVaccency(Integer numberOfVaccency) {
		this.numberOfVaccency = numberOfVaccency;
	}
	@Override
	public String toString() {
		return "JobsBean [jobId=" + jobId + ", JobTitle=" + JobTitle + ", qualification=" + qualification
				+ ", jobLocation=" + jobLocation + ", organizationName=" + organizationName + ", jobDescription="
				+ jobDescription + ", experience=" + experience + ", jobSalary=" + jobSalary + ", numberOfVaccency="
				+ numberOfVaccency + "]";
	}
	public JobsBean(String jobTitle, String qualification, String jobLocation, String organizationName,
			String jobDescription, String experience, double jobSalary, Integer numberOfVaccency) {
		super();
		this.jobId = jobId;
		this.JobTitle = jobTitle;
		this.qualification = qualification;
		this.jobLocation = jobLocation;
		this.organizationName = organizationName;
		this.jobDescription = jobDescription;
		this.experience = experience;
		this.jobSalary = jobSalary;
		this.numberOfVaccency = numberOfVaccency;
	}
	public JobsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
