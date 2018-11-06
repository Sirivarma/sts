package cg.jobapplication.jobapplication.service.applicationtest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cg.jobapplication.jobapplication.bean.ApplicationBean;
import cg.jobapplication.jobapplication.bean.ValidateApplication;
import cg.jobapplication.jobapplication.repository.ApplicationBeanRepository;
import cg.jobapplication.jobapplication.repository.ValidateApplicationRepository;
import cg.jobapplication.jobapplication.service.ApplicationBeanServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ApplicationBeanServiceImplTest {
	
	@Mock
	ApplicationBeanRepository applicationrepositorymock;

	@Mock
	ValidateApplicationRepository validateApplicationRepositorymock;

	@InjectMocks
	
	ApplicationBeanServiceImpl applicationbeanserviceimplmock;

	@Test
	public void addApplication() throws Exception {
		ApplicationBean appBean =  new ApplicationBean();
		appBean.setApplicantName("applicantName");
		appBean.setApplicationId(1);
		appBean.setComments("comments");
		
	
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormatter.format(new Date());
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		appBean.setDateOfBirth(date);
		appBean.setEducationalQualification("educationalQualification");
		appBean.setEmailId("siri@gmail.com");
		appBean.setFatherName("fatherName");
		appBean.setLanguage("language");
		appBean.setModifiedDate(date);
		appBean.setNationality("nationality");
		appBean.setPermenantAddress("permenantAddress");
        appBean.setPostApplied("postApplied");
        appBean.setPresentAddress("presentAddress");
        appBean.setPrimarySkills("primarySkills");
        appBean.setReligion("religion");
        appBean.setSpecialization("specialization");
        appBean.setStatus("status");
	

		when(applicationrepositorymock.save(appBean)).thenReturn(appBean);
		ApplicationBean app=applicationbeanserviceimplmock.addApplication(appBean);
		assertEquals(app, appBean);

	}
	@Test
	public void retriveAll() throws Exception{
		ApplicationBean appBean =  new ApplicationBean();
		List<ApplicationBean> appList = new ArrayList<>();
		appBean.setApplicantName("applicantName");
		appBean.setApplicationId(1);
		appBean.setComments("comments");
		
	
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormatter.format(new Date());
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		appBean.setDateOfBirth(date);
		appBean.setEducationalQualification("educationalQualification");
		appBean.setEmailId("siri@gmail.com");
		appBean.setFatherName("fatherName");
		appBean.setLanguage("language");
		appBean.setModifiedDate(date);
		appBean.setNationality("nationality");
		appBean.setPermenantAddress("permenantAddress");
        appBean.setPostApplied("postApplied");
        appBean.setPresentAddress("presentAddress");
        appBean.setPrimarySkills("primarySkills");
        appBean.setReligion("religion");
        appBean.setSpecialization("specialization");
        appBean.setStatus("status");
        appList.add(appBean);
       when(applicationrepositorymock.findAll()).thenReturn(appList);
		List<ApplicationBean> app=applicationbeanserviceimplmock.retriveAllValues();
				assertEquals(app, appList);
		

		

	}
	@Test
	public void retriveOne() throws Exception {
		ApplicationBean appBean =  new ApplicationBean();
		//List<ApplicationBean> appList = new ArrayList<>();
		appBean.setApplicantName("applicantName");
		appBean.setApplicationId(1);
		appBean.setComments("comments");
		
	
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormatter.format(new Date());
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		appBean.setDateOfBirth(date);
		appBean.setEducationalQualification("educationalQualification");
		appBean.setEmailId("siri@gmail.com");
		appBean.setFatherName("fatherName");
		appBean.setLanguage("language");
		appBean.setModifiedDate(date);
		appBean.setNationality("nationality");
		appBean.setPermenantAddress("permenantAddress");
        appBean.setPostApplied("postApplied");
        appBean.setPresentAddress("presentAddress");
        appBean.setPrimarySkills("primarySkills");
        appBean.setReligion("religion");
        appBean.setSpecialization("specialization");
        appBean.setStatus("status");
       //appList.add(appBean);
       when(applicationrepositorymock.findOne(1)).thenReturn(appBean);
     		ApplicationBean app=applicationbeanserviceimplmock.retriveOne(1);

				assertEquals(app, appBean);
		
		
		

		
		
	}
	@Test
	public void applicationStatus() throws Exception {
		
		ValidateApplication validateApp1 = 	new ValidateApplication();
		validateApp1.setApplicationId(1);
		validateApp1.setApplicantName("applicantName");
		validateApp1.setStatus("status");
		when(validateApplicationRepositorymock.save(validateApp1)).thenReturn(validateApp1);
 		ValidateApplication vp =applicationbeanserviceimplmock.applicationStatus(validateApp1);
 		assertEquals(vp,validateApp1);

	}



}
