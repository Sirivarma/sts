package cg.jobapplication.jobapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.jobapplication.jobapplication.bean.JobsBean;

@Repository
public interface JobsBeanRepository extends JpaRepository< JobsBean ,Integer> {

}
