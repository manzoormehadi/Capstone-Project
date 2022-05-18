package com.stackroute.service;


import java.util.List;

import com.stackroute.exceptions.RecommendAlreadyExistsException;
import com.stackroute.exceptions.RecommendNotFoundException;
import com.stackroute.model.Recommend;

public interface RecommendService {
	
	boolean saveRecommend(Recommend recommend) throws RecommendAlreadyExistsException;
	
	boolean deleteRecommend(String id) throws RecommendNotFoundException;
	
	public List<Recommend> getAllRecommend(String loggedInUser) throws RecommendNotFoundException;
	
	
}
