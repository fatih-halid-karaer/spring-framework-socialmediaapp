package com.example.socialmedia.exceptions;



import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationInfo {
	private Map<String , String> validationErrors;
}
