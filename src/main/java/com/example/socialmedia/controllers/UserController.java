package com.example.socialmedia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialmedia.requests.CreateUserRequest;
import com.example.socialmedia.responses.GetAllUsersResponse;
import com.example.socialmedia.services.UserService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
   private UserService us;
   @GetMapping("/getAll")
	public List<GetAllUsersResponse> getAll() { 
		return us.getAll();
	}
   
   @PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid()  CreateUserRequest createUserRequest) {
		this.us.add(createUserRequest);
	}
}
