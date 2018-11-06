package cg.jobapplication.jobapplication.service.registertest;

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

import cg.jobapplication.jobapplication.bean.Register;
import cg.jobapplication.jobapplication.repository.RegisterRepository;
import cg.jobapplication.jobapplication.service.RegisterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class RegisterServiceImplTest {
	@Mock
	RegisterRepository registerRepositorymock;
	@InjectMocks
	RegisterServiceImpl registerserviceimplmock; 
	@Test
	
	public void AddRegister() throws Exception{
		Register reg = new Register();
		reg.setEmailId("siri@gmail.com");
		reg.setCandidateName("candidateName");
		reg.setCandidateId(1);
		reg.setContactNo("contactNo");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = dateFormatter.format(new Date());
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		reg.setDateOfBirth(date);
		reg.setGender("gender");
		reg.setPassword("password");
		reg.setQualification("qualification");
		reg.setUserType("userType");
		when(registerRepositorymock.save(reg)).thenReturn(reg);
		Register reg1 =registerserviceimplmock.AddRegister(reg);
		assertEquals(reg1, reg);

	}
@Test
public void RetriveAll() throws Exception{
	Register reg = new Register();
	List<Register> regList = new ArrayList<>();

	reg.setEmailId("siri@gmail.com");
	reg.setCandidateName("candidateName");
	reg.setCandidateId(1);
	reg.setContactNo("contactNo");
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = dateFormatter.format(new Date());
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	reg.setDateOfBirth(date);
	reg.setGender("gender");
	reg.setPassword("password");
	reg.setQualification("qualification");
	reg.setUserType("userType");
	when(registerRepositorymock.findAll()).thenReturn(regList);
    List<Register> reg1 =registerserviceimplmock.RetriveAll();

	assertEquals(reg1, regList);

	

}
@Test
public void retiveOne()throws Exception {
	Register reg = new Register();
	reg.setEmailId("siri@gmail.com");
	reg.setCandidateName("candidateName");
	reg.setCandidateId(1);
	reg.setContactNo("contactNo");
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateString = dateFormatter.format(new Date());
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	reg.setDateOfBirth(date);
	reg.setGender("gender");
	reg.setPassword("password");
	reg.setQualification("qualification");
	reg.setUserType("userType");
	when(registerRepositorymock.findOne(1)).thenReturn(reg);
	Register reg1 =registerserviceimplmock.retiveOne(1);
	assertEquals(reg1, reg);

}

}
