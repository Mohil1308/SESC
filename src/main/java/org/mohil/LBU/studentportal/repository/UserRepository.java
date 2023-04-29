package org.mohil.LBU.studentportal.repository;

import org.mohil.LBU.studentportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	User findByStudentId(String studentId);
}
