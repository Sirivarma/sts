package cg.jobapplication.jobapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cg.jobapplication.jobapplication.bean.ApplicationBean;
import cg.jobapplication.jobapplication.bean.JobsBean;
import cg.jobapplication.jobapplication.bean.Register;
import cg.jobapplication.jobapplication.bean.ValidateApplication;
import cg.jobapplication.jobapplication.service.ApplicationBeanService;
import cg.jobapplication.jobapplication.service.JobsBeanService;
import cg.jobapplication.jobapplication.service.RegisterService;

@RestController

public class ExamController {
	public static java.util.Date utilDate = new java.util.Date();
	public static java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	public static int count = 0;

	@Autowired
	ApplicationBeanService applicationservice;

	@Autowired
	RegisterService registerService;

	@Autowired
	JobsBeanService jobsBeanService;






	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ResponseEntity<Register> getHome() throws Exception {
		
		Register reg = new Register("Admin", sqlDate, "B.Tech", "Admin1@gmail.com", "Admin123", "9632587410", "Female",
				"Admin");
		Register reg2 = new Register("Siri", sqlDate, "B.Tech", "siri.m@gmail.com", "Admin123", "7410258963", "Female",
				"Admin");
		System.out.println(reg);
		System.out.println(reg2);
		registerService.AddRegister(reg2);
		Register register = registerService.AddRegister(reg);
		if (register == null) {
			return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Register>(register, HttpStatus.OK);
	}
	
	// AddRegister
	@RequestMapping(value = { "/addValues" }, method = RequestMethod.POST)
	public ResponseEntity<Register> addValues(@RequestBody Register reg) throws Exception {
	
		Register register = registerService.AddRegister(reg);
		if (register == null) {
			return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Register>(register, HttpStatus.OK);
	}

	/*return "register";
	}*/

	// RetriveById
	@RequestMapping(value = "/getValues/{id}", method = RequestMethod.GET)

	public ResponseEntity<Register> retiveOne(@PathVariable("id") int candidateId) throws Exception {

		Register register = registerService.retiveOne(candidateId);
		if (register == null) {
			return new ResponseEntity<Register>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Register>(register, HttpStatus.OK);
	}

	// RetriveAll
	@RequestMapping(value = { "/getValues" }, method = RequestMethod.GET)
	public List<Register> getValues() throws Exception {
		List<Register> regList = registerService.RetriveAll();

		return regList;
	}




	// ApplicationBean


	@RequestMapping(value = { "/applicationbean" }, method = RequestMethod.GET)
	public ResponseEntity<ApplicationBean> getApplications() throws Exception {
		/*	ApplicationBean app = null;
		System.out.println("Count---" + count);*/

		ApplicationBean app1 = new ApplicationBean("siri", "btech", "siri@gmail.com", "sai", "hindu", "india", sqlDate,
				"analyst", "computers", "java", "english", "hyderabad", "vizag",  "null", "Applied", sqlDate);

		System.out.println(app1);
		//app= applicationservice.addApplication(app1);

		ApplicationBean app2 = new ApplicationBean("value", "value", "value@gmail.com", "value", "value", "value",
				sqlDate, "value", "value", "value", "value", "value", "value",  "value", "value",
				sqlDate);

		System.out.println(app2);
		ApplicationBean app	= applicationservice.addApplication(app2);

		if(app == null)  {
			return new ResponseEntity<ApplicationBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationBean>(app, HttpStatus.OK);
	}



	// AddApplication

	@RequestMapping(value = "/addApp", method = RequestMethod.POST)
	public ResponseEntity<ApplicationBean> addApp(@RequestBody ApplicationBean app1) throws Exception {

		ApplicationBean app = applicationservice.addApplication(app1);
		if(app == null)  {
			return new ResponseEntity<ApplicationBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationBean>(app, HttpStatus.OK);
	}

	/*	
		return "posted";
	}
	 */

	@RequestMapping(value = "/validateApp", method = RequestMethod.POST)
	public ValidateApplication validateApplication(@RequestBody ValidateApplication validateApp)throws Exception {
		//System.err.println("validateApplication");
		ValidateApplication validateApp1 = 	new ValidateApplication();


		validateApp1=applicationservice.applicationStatus(validateApp);

		return validateApp1;
	}

	// RetriveAll
	//HR WILL SEE THE LIST OF APPLICATIONS
	@RequestMapping(value = { "/retriveall" }, method = RequestMethod.GET)
	public List<ApplicationBean> retriveall() throws Exception {

		List<ApplicationBean> appl = applicationservice.retriveAllValues();

		return appl;
	}
	//Retrive By Id
	@RequestMapping(value = "/retriveby/{id}", method = RequestMethod.GET)

	public ResponseEntity<ApplicationBean> retriveOne(@PathVariable("id") int applicationId) throws Exception {

		ApplicationBean app = applicationservice.retriveOne(applicationId);
		if (app == null) {
			return new ResponseEntity<ApplicationBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationBean>(app, HttpStatus.OK);
	}


	// JobsBean
	@RequestMapping(value = { "/jobsbean" }, method = RequestMethod.GET)
	public ResponseEntity<JobsBean> getJobs() throws Exception {
		/*JobsBean jb = null;
		System.out.println("Count---" + count);*/

		JobsBean jb1 = new JobsBean("analyst", "btech", "hyderabad", "capgemini", "software", "2 or more", 20000, 2);
		System.out.println(jb1);
		JobsBean jb = jobsBeanService.addNew(jb1);
		if (jb == null) {
			return new ResponseEntity<JobsBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JobsBean>(jb, HttpStatus.OK);
	}

	/*	System.err.println(jb);
		return jb;*/



	@RequestMapping(value = { "/addJb" }, method = RequestMethod.POST)
	public ResponseEntity<JobsBean> addJb(@RequestBody JobsBean jb1) throws Exception {
		//System.err.println("err");
		JobsBean jb = jobsBeanService.addNew(jb1);
		if (jb == null) {
			return new ResponseEntity<JobsBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JobsBean>(jb, HttpStatus.OK);
	}
	/*return "job";
	}
	 */
	@RequestMapping(value = { "/retrive" }, method = RequestMethod.GET)
	public List<JobsBean> retriveAll() throws Exception {
		List<JobsBean> jbs = jobsBeanService.retriveAllValues();
		return jbs;
	}

	@RequestMapping(value = "/retrive/{id}", method = RequestMethod.GET)

	public ResponseEntity<JobsBean> retriveOne1(@PathVariable("id") int jobId) throws Exception {

		JobsBean jb = jobsBeanService.retriveOne(jobId);
		if (jb == null) {
			return new ResponseEntity<JobsBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JobsBean>(jb, HttpStatus.OK);
	}

	@RequestMapping(value = "/getapplicationsforjob/{id}", method = RequestMethod.GET)

	public List<ApplicationBean> getApplicationsForJob(@PathVariable("id") int applicationId) throws Exception {
		System.err.println("get applications");
		
		List<ApplicationBean> listjob= applicationservice.getApplicationsForJob( applicationId);

		System.err.println(listjob);
		return listjob;


	}
}

