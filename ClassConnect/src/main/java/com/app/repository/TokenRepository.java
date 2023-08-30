package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Token;
@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

//	  @Query(value = "select t from Token t inner join Login l on t.login.loginId = l.loginId where l.loginId = :id and (t.expired = false or t.revoked = false)")
	  @Query(value = "select t from Token t inner join Login l on t.login.loginId = l.loginId where l.loginId = :id and (t.expired = false or t.revoked = false)")

//	  @Query(value = " SELECT t FROM Token t\n"
//	  		+ "	  INNER JOIN Login l ON t.login.loginId = l.loginId\n"
//	  		+ "	  WHERE l.loginId = :id\n"
//	  		+ "	  AND (t.expired = false OR t.revoked = false)")
//	 

	  
	  List<Token> findAllValidTokenByLogin(Long id);

	  Optional<Token> findByToken(String token);
	}