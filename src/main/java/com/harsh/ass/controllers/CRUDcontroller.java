package com.harsh.ass.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.ass.entities.User;
import com.harsh.ass.exception.ResourceNotFoundException;
import com.harsh.ass.repos.UserRepository;

@RestController
public class CRUDcontroller {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/create")
	public String createEmployee(@Valid @RequestBody User user)
	{
		userRepository.save(user);
		return "success";
	}
	
	
	
	@GetMapping(value="/read/{id}")
	public User getEmployeeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException
	{
		User user =userRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " +id));
		return user;
	}
	
	  @GetMapping("/readAll")
	  public List<User> getAllUsers() {
	    return userRepository.findAll();
	  }
	
	@PutMapping("/update/{id}")
	public String updateEmployeeDetails(@PathVariable(value = "id") Long id, @Valid @RequestBody User userDetails) throws ResourceNotFoundException
	{
		User user =userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		user.setId(id);
		user.setAge(userDetails.getAge());
		user.setDepartment(userDetails.getDepartment());
		user.setEmpName(userDetails.getEmpName());
		user.setExp(userDetails.getPhone());
		user.setSkills(userDetails.getSkills());
		userRepository.save(user);
		return "success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) throws ResourceNotFoundException
	{
		User user =userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
		userRepository.delete(user);
		return "success";

	}
	
	
	
	
	
	
}
