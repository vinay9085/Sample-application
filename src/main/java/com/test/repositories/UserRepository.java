package com.test.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

//	@Query(value = "select * from user u  " 
//			+ " where LOWER(u.fname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
//			+ " LOWER(u.lname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) "
//			+ " \n#pageable\n", 
//			countQuery = "select count(*) from user u"
//					+ " where LOWER(u.fname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
//					+ " LOWER(u.lname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) ", nativeQuery = true)
//	Page<User> findBySearchTermNative(@Param("searchTerm") String searchTerm, Pageable pageable);
	
	@Query(
			value = "SELECT u FROM User u WHERE LOWER(u.fname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR LOWER(u.lname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) ",
			countQuery = "SELECT COUNT(u) FROM User u WHERE LOWER(u.fname) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR LOWER(u.lname) LIKE LOWER(CONCAT('%',:searchTerm, '%'))"
		)
	Page<User> findBySearch(@Param("searchTerm") String searchTerm, Pageable pageable);


}
