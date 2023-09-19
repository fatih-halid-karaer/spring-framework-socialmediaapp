package com.example.socialmedia.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialmedia.requests.CreateAdminRequest;
import com.example.socialmedia.requests.UpdateAdminRequest;
import com.example.socialmedia.responses.GetAllAdminsResponse;
import com.example.socialmedia.responses.GetByIdAdminResponse;
import com.example.socialmedia.responses.GetByNameAdminResponse;
import com.example.socialmedia.services.AdminService;

import lombok.AllArgsConstructor;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/admins")
@AllArgsConstructor
public class AdminController {
	AdminService as;
	@GetMapping()
	public List<GetAllAdminsResponse> getAll() {
		//Spring IoC 
		return as.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdAdminResponse getById(@PathVariable int id) {
		//Spring IoC 
		return as.getById(id);
	}
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateAdminRequest createAdminRequest) {
		this.as.add(createAdminRequest);
		
	}
	
	@PutMapping
	public void update(@RequestBody UpdateAdminRequest updateAdminRequest) {
		this.as.update(updateAdminRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.as.delete(id);
	}
	
	@GetMapping("/name")
	public GetByNameAdminResponse getByName(String name) {
		return as.getByName(name);
	}
}
