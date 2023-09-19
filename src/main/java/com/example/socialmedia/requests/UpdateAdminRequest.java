package com.example.socialmedia.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdminRequest {
    private int id;
    private String name;
    private String adminBio;
    private String adminMail;
}
