package com.dcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.entity.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer>{

	
}
