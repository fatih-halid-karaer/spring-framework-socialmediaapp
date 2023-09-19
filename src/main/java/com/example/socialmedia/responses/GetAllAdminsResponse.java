package com.example.socialmedia.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAdminsResponse {
      private int id;
      private String name;
      private String admin_bio;
      private String admin_mail;
      
}
