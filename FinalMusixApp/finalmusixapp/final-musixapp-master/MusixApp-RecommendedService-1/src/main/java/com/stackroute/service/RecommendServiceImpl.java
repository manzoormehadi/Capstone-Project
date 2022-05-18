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
		this.recommendRepo = recommendRepo;
	}
	
	@Override
	public boolean saveRecommend(Recommend recommend) throws RecommendAlreadyExistsException {
		
		Optional<Recommend> u1 = recommendRepo.findById(recommend.getId());
		if(!(u1.isPresent())) {
			Recommend recommend1=recommendRepo.save(recommend);
			return true;

		}
			return false;
	}
	
	@Override
	public boolean deleteRecommend(String id) throws RecommendNotFoundException {
		
		Optional<Recommend> u1 = recommendRepo.findById(id);
		if(!(u1.isPresent())) {
			throw new RecommendNotFoundException("Recommend not found");			
		}
				recommendRepo.delete(u1.get());
				return true;
		
	}

	@Override
	public List<Recommend> getAllRecommend(String loggedInUser) throws RecommendNotFoundException {
		List<Recommend> recommend = recommendRepo.findbyUserId(loggedInUser);
		
		if(recommend == null) {
			throw new RecommendNotFoundException("recommend not found");
		}
		return recommend;
	}
	

}
