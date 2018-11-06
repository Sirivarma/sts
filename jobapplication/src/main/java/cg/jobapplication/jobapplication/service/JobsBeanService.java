package cg.jobapplication.jobapplication.service;

import java.util.List;

import cg.jobapplication.jobapplication.bean.JobsBean;
public interface JobsBeanService {

	public JobsBean addNew(JobsBean jobsBean) throws Exception;
	
	public List<JobsBean> retriveAllValues() throws Exception;
	
	public JobsBean retriveOne(int id) throws Exception;

	
}
