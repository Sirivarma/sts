package cg.jobapplication.jobapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.jobapplication.jobapplication.bean.ValidateApplication;

@Repository
public interface ValidateApplicationRepository extends JpaRepository<ValidateApplication, Integer> {

}
