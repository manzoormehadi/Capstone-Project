package com.stackroute.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.model.Recommend;
import com.stackroute.service.RecommendService;

@RestController
@RequestMapping("/api/v1/recommendservice")
@CrossOrigin("*")
public class RecommendController {

	@Autowired
	private RecommendService recommendService;
	
	@PostMapping
	public ResponseEntity<?> registerRecommend(@RequestBody Recommend recommend){
		try {
			recommendService.saveRecommend(recommend);
			return new ResponseEntity<String>("Recommended Music added successfully", HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecommend(@PathVariable(value="id") String id){
		try {
			recommendService.deleteRecommend(id);
			return new ResponseEntity<String>("Recommend deleted successfully", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/getAllRecommended/{loginUser}")
	public ResponseEntity<?> getAllRecommend(@PathVariable(value="loginUser") String loginUser){
		try {
			List<Recommend> recommend = recommendService.getAllRecommend(loginUser);
			if(recommend == null) {
				throw new Exception("Recommended not available");
			}
			return new ResponseEntity<List<Recommend>>(recommend, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("{\"message\": \""+e.getMessage()+"\"}", HttpStatus.UNAUTHORIZED);
		}
	}
	
}
