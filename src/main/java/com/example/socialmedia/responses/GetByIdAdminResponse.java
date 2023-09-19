package com.example.socialmedia.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAdminResponse {
	 private int id;
	    private String name;
	    private String adminBio;
	    private String adminMail;
}
