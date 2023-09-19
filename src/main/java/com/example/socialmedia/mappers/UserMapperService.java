package com.example.socialmedia.mappers;

import org.modelmapper.ModelMapper;

public interface UserMapperService {
	ModelMapper forResponse();
	ModelMapper forRequests();
}
