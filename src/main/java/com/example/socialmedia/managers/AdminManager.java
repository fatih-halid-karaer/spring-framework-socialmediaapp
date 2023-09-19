package com.example.socialmedia.managers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.socialmedia.entities.Admin;
import com.example.socialmedia.mappers.UserMapperService;
import com.example.socialmedia.repository.AdminRepository;
import com.example.socialmedia.requests.CreateAdminRequest;
import com.example.socialmedia.requests.UpdateAdminRequest;
import com.example.socialmedia.responses.GetAllAdminsResponse;
import com.example.socialmedia.responses.GetByIdAdminResponse;
import com.example.socialmedia.responses.GetByNameAdminResponse;
import com.example.socialmedia.rules.AdminRules;
import com.example.socialmedia.services.AdminService;


import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AdminManager implements AdminService{
    private AdminRepository ar;
    private UserMapperService ums;
    private AdminRules arules;
	@Override
	public List<GetAllAdminsResponse> getAll() {
		List<Admin> admins = ar.findAll();
		List<GetAllAdminsResponse> aresponse = admins.stream()
				.map(admin -> this.ums.forResponse().map(admin, GetAllAdminsResponse.class)).collect(Collectors.toList());
		return aresponse;
	}

	@Override
	public GetByIdAdminResponse getById(int id) {
Admin admin = this.ar.findById(id).orElseThrow(); //Bulamazsan hata fırlat anlamında.
		
		GetByIdAdminResponse resp = this.ums.forResponse().map(admin, GetByIdAdminResponse.class);
		
		return resp;
	}

	@Override
	public void add(CreateAdminRequest createAdminRequest) {
		this.arules.checkIfAdminNameExists(createAdminRequest.getName());
		//createBrandRequesti brande mapliyoruz.
		Admin admin = this.ums.forRequests().map(createAdminRequest, Admin.class); 
		this.ar.save(admin);
	}

	@Override
	public void update(UpdateAdminRequest updateAdminRequest) {
		// TODO Auto-generated method stub
		Admin admin = this.ums.forRequests().map(updateAdminRequest, Admin.class);
		this.ar.save(admin);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.ar.deleteById(id);
	}

	@Override
	public GetByNameAdminResponse getByName(String name) {
	Admin admin = this.ar.getByName(name);
		
		GetByNameAdminResponse resp	= this.ums.forResponse().map(admin, GetByNameAdminResponse.class);
		
		return resp;
	}

}
