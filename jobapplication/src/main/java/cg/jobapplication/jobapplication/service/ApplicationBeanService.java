package cg.jobapplication.jobapplication.service;

import java.util.List;

import cg.jobapplication.jobapplication.bean.ApplicationBean;
import cg.jobapplication.jobapplication.bean.ValidateApplication;


public interface ApplicationBeanService {
	
	public ApplicationBean addApplication(ApplicationBean app) throws Exception;
	public List<ApplicationBean> retriveAllValues() throws Exception;
	public ApplicationBean retriveOne(int id) throws Exception;
//	public int updateApplication(String status,String comments,int appId,Date date);
	public ValidateApplication applicationStatus(ValidateApplication validateApp) throws Exception;
	public List<ApplicationBean> getApplicationsForJob(int appid) throws Exception;
	
	
}
