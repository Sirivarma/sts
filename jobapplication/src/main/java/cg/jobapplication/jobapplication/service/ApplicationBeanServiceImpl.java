package cg.jobapplication.jobapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.jobapplication.jobapplication.bean.ApplicationBean;
import cg.jobapplication.jobapplication.bean.JobsBean;
import cg.jobapplication.jobapplication.bean.ValidateApplication;
import cg.jobapplication.jobapplication.repository.ApplicationBeanRepository;
import cg.jobapplication.jobapplication.repository.JobsBeanRepository;
import cg.jobapplication.jobapplication.repository.ValidateApplicationRepository;
@Service
public class ApplicationBeanServiceImpl implements ApplicationBeanService {
	
	@Autowired
	ApplicationBeanRepository applicationrepository;
	
	@Autowired
	JobsBeanRepository jobsbeanrepository;
	@Autowired
	ValidateApplicationRepository validateApplicationRepository;
	@Override
	public ApplicationBean addApplication(ApplicationBean app) throws Exception{
		ApplicationBean applicationbean=applicationrepository.save(app);
		return applicationbean;
	}
	public List<ApplicationBean> retriveAllValues() throws Exception{
		List<ApplicationBean> aList=applicationrepository.findAll();
		return aList;
	}
	/*@Override
	public int updateApplication(String status, String comments, int appId,Date date) {
		
		return applicationrepository.updateApplication(status, comments, appId,date);
	}*/
	@Override
	public ApplicationBean retriveOne(int id) throws Exception {
		
		ApplicationBean appBean=applicationrepository.findOne(id);
		appBean.setApplicantName(appBean.getApplicantName());
		 return appBean;
		 
	}
	@Override
	public ValidateApplication applicationStatus(ValidateApplication validateApp) throws Exception {
		
		//validateApplicationRepository.save(validateApplication);
		ApplicationBean appBean =  new ApplicationBean();
		ApplicationBean appBean2 =  new ApplicationBean();
		
	appBean.setStatus(validateApp.getStatus());
		appBean.setApplicantName(validateApp.getApplicantName());
		appBean.setApplicationId(validateApp.getApplicationId());
		appBean2=applicationrepository.findOne(validateApp.getApplicationId());
		appBean.setComments(appBean2.getComments());
		appBean.setDateOfBirth(appBean2.getDateOfBirth());
		appBean.setEducationalQualification(appBean2.getEducationalQualification());
		appBean.setEmailId(appBean2.getEmailId());
		appBean.setFatherName(appBean2.getFatherName());
		appBean.setLanguage(appBean2.getLanguage());
		appBean.setModifiedDate(appBean2.getModifiedDate());
		appBean.setNationality(appBean2.getNationality());
		appBean.setPermenantAddress(appBean2.getPermenantAddress());
		appBean.setPostApplied(appBean2.getPostApplied());
		appBean.setPrimarySkills(appBean2.getPrimarySkills());
		appBean.setPresentAddress(appBean2.getPresentAddress());
		appBean.setReligion(appBean2.getReligion());
		appBean.setSpecialization(appBean2.getSpecialization());
		//appBean.setUserId(appBean2.getUserId());
		appBean=applicationrepository.save(appBean);
		System.err.println(appBean.getStatus());
		return validateApp;
	}
	@Override
	public List<ApplicationBean> getApplicationsForJob(int appid) throws Exception {
		List<ApplicationBean> appBeanreal=new ArrayList<ApplicationBean>();
		JobsBean job=jobsbeanrepository.findOne(appid);
		//ApplicationBean appBean =  new ApplicationBean();
		List<ApplicationBean> appBean= applicationrepository.findAll();
		for (ApplicationBean applicationBean : appBean) {
			if(applicationBean.getPostApplied().equals(job.getJobTitle())) {
			
				appBeanreal.add(applicationBean);
		}
		
	
	}
return appBeanreal;
	}
}
	
	






