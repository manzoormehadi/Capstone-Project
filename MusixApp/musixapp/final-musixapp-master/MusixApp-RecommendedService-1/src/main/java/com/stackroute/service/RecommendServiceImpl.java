package com.stackroute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.exceptions.RecommendAlreadyExistsException;
import com.stackroute.exceptions.RecommendNotFoundException;
import com.stackroute.model.Recommend;
import com.stackroute.repository.RecommendRepository;

@Service
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private final RecommendRepository recommendRepo;
	
	public RecommendServiceImpl(RecommendRepository recommendRepo) {
		//write the code
	}
	
	@Override
	public boolean saveRecommend(Recommend recommend) throws RecommendAlreadyExistsException {
		
		//write the code
	}
	
	@Override
	public boolean deleteRecommend(String id) throws RecommendNotFoundException {
		
		//write the code
		
	}

	@Override
	public List<Recommend> getAllRecommend(String loggedInUser) throws RecommendNotFoundException {
		//write the code
	}
	

}
