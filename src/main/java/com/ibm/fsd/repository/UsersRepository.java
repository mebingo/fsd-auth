package com.ibm.fsd.repository;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.fsd.entity.Userinfolist;

public interface UsersRepository extends JpaRepository<Userinfolist, Integer> {
		
	Userinfolist findByUsername(String username);
	// Users findByEmail(String email);
	
//	#########################################################################
  

 
 @Modifying
 @Transactional
 @Query("update Userinfolist u set u.confirmed = :confirmed where u.username=:username")
 int saveUsersByUsernameAndConfirmed(@Param("username") String username, @Param("confirmed") String confirmed);

 @Modifying
 @Transactional
 @Query("update Userinfolist u set u.lastupdate = :lastupdate where u.username=:username")
 int saveUsersByUsernameAndLastupdate(@Param("username") String username, @Param("lastupdate") Date lastupdate);

 Userinfolist findByUsernameAndPassword(String username, String password);

// @GeneratedValue(strategy = GenerationType.IDENTITY)
// Userinfolist saveUsers(Userinfolist userinfolist);
 
  
}