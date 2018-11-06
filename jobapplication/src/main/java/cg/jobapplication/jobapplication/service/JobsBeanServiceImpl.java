package cg.jobapplication.jobapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.jobapplication.jobapplication.bean.JobsBean;
import cg.jobapplication.jobapplication.repository.JobsBeanRepository;
@Service
public class JobsBeanServiceImpl implements JobsBeanService {
	
	@Autowired
	JobsBeanRepository jobsBeanRepository;
	
	@Override
	public JobsBean addNew(JobsBean jobsBean) throws Exception {
		JobsBean job=jobsBeanRepository.save(jobsBean);
		return job;
	}

	@Override
	public List<JobsBean> retriveAllValues() throws Exception {
		List<JobsBean> jobList=jobsBeanRepository.findAll();
		return jobList;
	}

	@Override
	public JobsBean retriveOne(int id) throws Exception {
		JobsBean job=jobsBeanRepository.findOne(id);
		return job;
	}

	

}
