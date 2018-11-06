package cg.jobapplication.jobapplication.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import cg.jobapplication.jobapplication.bean.Register;
import cg.jobapplication.jobapplication.exception.RecruitmentManagementException;
import cg.jobapplication.jobapplication.repository.RegisterRepository;
@Service(value="registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterRepository registerRepository;
	
	 /* public UserDetails loadUserBycandidateName(String candidateId) throws Exception {
	       Register register =registerRepository.findBycandidateName(candidateId);
	       if(register == null) {
			throw new Exception("Invalid Username or Password");
			}
	       return org.springframework.security.core.RegisterService.Register(register.getCandidateName(),register.getCandidateId(),register.getContactNo(),register.getDateOfBirth(),register.getEmailId(),register.getGender(),register.getPassword(),register.getQualification(),
					register.getUserType(),getAuthority());
	  }
*/

private List<SimpleGrantedAuthority> getAuthority() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
}

	@Override
	public Register AddRegister(Register registerUser) throws Exception{
		Register register=registerRepository.save(registerUser);
	
		return register;
	}
	@Override
	public Register retiveOne(int userId) throws Exception,RecruitmentManagementException {
		Register register=registerRepository.findOne(userId);
		
		return register;
	}

	@Override
	public List<Register> RetriveAll() throws Exception{

		List<Register> registerList=registerRepository.findAll();
		return registerList;
	}

	



	

	
	
	}

	
 
	

