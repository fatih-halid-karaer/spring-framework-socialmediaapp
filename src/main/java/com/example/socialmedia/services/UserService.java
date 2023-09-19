package com.example.socialmedia.services;
import java.util.List;

import com.example.socialmedia.requests.CreateUserRequest;
import com.example.socialmedia.responses.GetAllUsersResponse;

public interface UserService {

	List<GetAllUsersResponse> getAll();
	void add(CreateUserRequest createUserRequest);
}
