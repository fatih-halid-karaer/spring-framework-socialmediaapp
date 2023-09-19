package com.example.socialmedia.managers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.socialmedia.entities.User;
import com.example.socialmedia.mappers.UserMapperService;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.requests.CreateUserRequest;
import com.example.socialmedia.responses.GetAllUsersResponse;
import com.example.socialmedia.services.UserService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class UserManager implements UserService  {
	
	
	private UserRepository ur;
    private UserMapperService ums;
	@Override
	public List<GetAllUsersResponse> getAll() {
		List<User> users = ur.findAll();
		List<GetAllUsersResponse> usersresponse = users.stream().map(user -> this.ums.forResponse().map(user,GetAllUsersResponse.class)).collect(Collectors.toList());
	    return usersresponse;
	}

	@Override
	public void add(CreateUserRequest createUserRequest) {
		User user = this.ums.forRequests().map(createUserRequest, User.class);
		this.ur.save(user);
	}
  
}
