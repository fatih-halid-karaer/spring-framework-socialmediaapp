package com.example.socialmedia.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
     private int id;
     private String name;
     private String userBio;
     private int userFollowers;
     private int userFollows;
     private String userMail;
     private String adminName;
}
