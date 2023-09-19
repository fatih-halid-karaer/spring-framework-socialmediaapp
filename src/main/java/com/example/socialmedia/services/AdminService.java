package com.example.socialmedia.services;

import java.util.List;

import com.example.socialmedia.requests.CreateAdminRequest;
import com.example.socialmedia.requests.UpdateAdminRequest;
import com.example.socialmedia.responses.GetAllAdminsResponse;
import com.example.socialmedia.responses.GetByIdAdminResponse;
import com.example.socialmedia.responses.GetByNameAdminResponse;

public interface AdminService {
	List<GetAllAdminsResponse> getAll();
	GetByIdAdminResponse getById(int id);
	void add(CreateAdminRequest createAdminRequest);
	void update(UpdateAdminRequest updateAdminRequest);
	void delete(int id);
	GetByNameAdminResponse getByName(String name);
}
