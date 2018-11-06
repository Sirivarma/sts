package cg.jobapplication.jobapplication.service.jobsbeantest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cg.jobapplication.jobapplication.bean.JobsBean;
import cg.jobapplication.jobapplication.repository.JobsBeanRepository;
import cg.jobapplication.jobapplication.service.JobsBeanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class JobsBeanServiceImplTest {
	
	@Mock 
	
	JobsBeanRepository jobsBeanRepositorymock;
	@InjectMocks

JobsBeanServiceImpl jobsbeanserviceimplmock; 
		
	@Test
	public void addNew()throws Exception{
		JobsBean jb1 = new JobsBean();
	jb1.setJobTitle("jobTitle");
	jb1.setJobId(1);
	jb1.setJobDescription("jobDescription");
	jb1.setExperience("experience");
	jb1.setJobLocation("jobLocation");
	jb1.setJobSalary(20000);
	jb1.setNumberOfVaccency(3);
	jb1.setQualification("qualification");
	jb1.setOrganizationName("organizationName");
	

	when(jobsBeanRepositorymock.save(jb1)).thenReturn(jb1);
	JobsBean jb =jobsbeanserviceimplmock.addNew(jb1);
	assertEquals(jb, jb1);


		
	}
	@Test
	public void  retriveAllValues() throws Exception {
		JobsBean jb1 = new JobsBean();
		List<JobsBean> jbList = new ArrayList<>();
		
		jb1.setJobTitle("jobTitle");
		jb1.setJobId(1);
		jb1.setJobDescription("jobDescription");
		jb1.setExperience("experience");
		jb1.setJobLocation("jobLocation");
		jb1.setJobSalary(20000);
		jb1.setNumberOfVaccency(3);
		jb1.setQualification("qualification");
		jb1.setOrganizationName("organizationName");

	       when(jobsBeanRepositorymock.findAll()).thenReturn(jbList);
	       List<JobsBean> jb=jobsbeanserviceimplmock.retriveAllValues();
			assertEquals(jb, jbList);

	}

	@Test
	public void retriveOne() throws Exception {
		JobsBean jb1 = new JobsBean();
		
		jb1.setJobTitle("jobTitle");
		jb1.setJobId(1);
		jb1.setJobDescription("jobDescription");
		jb1.setExperience("experience");
		jb1.setJobLocation("jobLocation");
		jb1.setJobSalary(20000);
		jb1.setNumberOfVaccency(3);
		jb1.setQualification("qualification");
		jb1.setOrganizationName("organizationName");
		

		when(jobsBeanRepositorymock.findOne(1)).thenReturn(jb1);
		JobsBean jb =jobsbeanserviceimplmock.retriveOne(1);
		assertEquals(jb, jb1);
		
	}

}
