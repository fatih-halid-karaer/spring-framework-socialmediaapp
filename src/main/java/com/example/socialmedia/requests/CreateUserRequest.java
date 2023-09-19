package com.example.socialmedia.requests;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
	@NotNull
	@NotBlank
	@Size(min=3, max=20)
	private String name;
	
	@NotNull
	@NotBlank
	@Size(min=3, max=20)
	private String userBio;
	@NotNull
	@NotBlank
	private int userFollowers;
	@NotNull
	@NotBlank
	private int userFollows;
	@NotNull
	@NotBlank
	@Size(min=3, max=20)
	private String userMail;
	@NotNull
	@NotBlank
	private int adminId;
}
