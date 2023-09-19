package com.example.socialmedia;
import java.util.HashMap;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.socialmedia.exceptions.AdminException;
import com.example.socialmedia.exceptions.ProblemInfo;
import com.example.socialmedia.exceptions.ValidationInfo;

@SpringBootApplication
@RestControllerAdvice
public class SocialmediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaApplication.class, args);
	}
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemInfo ProblemException(AdminException adminExcep) {
    	ProblemInfo problem = new ProblemInfo();
		problem.setMessage(adminExcep.getMessage());
		
		return problem;
    }
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ValidationInfo ValidationException(MethodArgumentNotValidException methodNotValidException) {
    	ValidationInfo validationProblem = new ValidationInfo();
        validationProblem.setValidationErrors(new HashMap<String,String>());
        for(FieldError fieldError : methodNotValidException.getBindingResult().getFieldErrors()  ) {
        	validationProblem.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        	
        }
        return validationProblem;
    }
    
    @Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
