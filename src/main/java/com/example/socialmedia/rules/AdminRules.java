package com.example.socialmedia.rules;

import org.springframework.stereotype.Service;

import com.example.socialmedia.exceptions.AdminException;
import com.example.socialmedia.repository.AdminRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AdminRules {
	private AdminRepository ar;
	
	public void checkIfAdminNameExists(String admin_name) {
		if(this.ar.existsByName(admin_name)) {
			throw new AdminException("Admin already exist");
		}
	}
}
