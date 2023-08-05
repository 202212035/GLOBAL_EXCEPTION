package com.abc.ent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.exception.ResourceNotFoundException;

@RestController
public class Controller 
{
	@Autowired
	private Urepo ur;
	
	@PostMapping("/add")
	public ResponseEntity<User> crt(@RequestBody User user)
	{
		User crtu = this.ur.save(user);
		return new ResponseEntity<>(crtu,HttpStatus.CREATED);
	}
	
	@GetMapping("/add")
	public ResponseEntity<List<User>> getAll()
	{
		return ResponseEntity.ok(this.ur.findAll());
	}
	
	@GetMapping("/add/{id}")
	public ResponseEntity<User> getSngl(@PathVariable Integer id)
	{
		User user = this.ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
		return ResponseEntity.ok(user);
//		return ResponseEntity.ok(this.ur.findById(id).get());
	}
	
	
//	@GetMapping("/add/{id}")
//	public ResponseEntity<User> getSngl(@PathVariable Integer id)
//	{
//		return ResponseEntity.ok(this.ur.findById(id).get());
//	}
}