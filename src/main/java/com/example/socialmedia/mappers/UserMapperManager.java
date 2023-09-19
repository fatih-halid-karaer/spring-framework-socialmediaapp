package com.example.socialmedia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserMapperManager implements UserMapperService {
	private ModelMapper um;
	
	@Override	
	public ModelMapper forResponse() {
		this.um.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.um;
	}

	@Override
	public ModelMapper forRequests() {
		this.um.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
	    return this.um;
	}
   
}
