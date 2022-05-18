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
		//write the code
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecommend(@PathVariable(value="id") String id){
		//write the code
	}
	
	
	@GetMapping("/getAllRecommended/{loginUser}")
	public ResponseEntity<?> getAllRecommend(@PathVariable(value="loginUser") String loginUser){
		//write the code
	}
	
}
