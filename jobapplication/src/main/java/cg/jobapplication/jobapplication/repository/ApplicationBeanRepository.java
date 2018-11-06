package cg.jobapplication.jobapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.jobapplication.jobapplication.bean.ApplicationBean;
@Repository
public interface ApplicationBeanRepository extends JpaRepository<ApplicationBean, Integer> {
	/*@Transactional
	 @Modifying
	 @Query("UPDATE ApplicationBean a SET a.status =:status, a.comments =:comment, a.modifiedDate =:date where a.applicationId =:appId")
	  int updateApplication(@Param("status") String status,@Param("comment") String comment,
	                                 @Param("appId") int appId,@Param("date") Date date);*/

	
	
} 

