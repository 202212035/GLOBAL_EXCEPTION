package com.two.entt;

import java.util.List;
//import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/User")
public class Controller
{
	@Autowired
	private UserRepo repo;
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user)
	{
		User create = repo.save(user);
		return new ResponseEntity<>(create,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> displayAll()
	{
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> displayById(@PathVariable Integer id)
	{
		User user = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
		return ResponseEntity.ok(user);
	}
}