package com.example.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmedia.entities.Admin;


public interface AdminRepository extends  JpaRepository<Admin, Integer> {
	Admin getByName(String admin_name);
	boolean existsByName(String admin_name);
}
