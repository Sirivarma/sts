package cg.jobapplication.jobapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.jobapplication.jobapplication.bean.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {
	/* Register findBycandidateName(String candidateName);

	Register findOne(int userId);
	
*/
	}


