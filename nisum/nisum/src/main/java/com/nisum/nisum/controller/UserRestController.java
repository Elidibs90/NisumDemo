package com.nisum.nisum.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.nisum.nisum.entity.User;
import com.nisum.nisum.exception.NotFoundException;
import com.nisum.nisum.service.UserService;

@RestController
@RequestMapping("/apiRest")
public class UserRestController {

	@Autowired
	private UserService userService;

	// http://127.0.0.1:8080/apiRest/users
	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll() {

		return ResponseEntity.ok(userService.findAll());
	}

	// http://127.0.0.1:8080/apiRest/users/1
	@GetMapping("/users/{userId}")
	public ResponseEntity<User>  getUser(@PathVariable int userId) {
		User user = userService.findById(userId);
		
		if (user == null) {
			throw new RuntimeException("User id not found -" + userId);
		}else
		return ResponseEntity.ok(user);
	}

	// http://127.0.0.1:8080/apiRest/addUser/
	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		try {
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		    Matcher matcher = pattern.matcher(user.getEmail());
		    boolean matchFound = matcher.find();
			if(matchFound) {
				return ResponseEntity.ok(this.userService.save(user));

			}else
			{
				Gson g = new Gson();
				NotFoundException notFoundException = new NotFoundException("El correo no es valido");
				return ResponseEntity.ok(g.toJson(notFoundException));
			}

		} catch (Exception e) {
			Gson g = new Gson();
			NotFoundException notFoundException = new NotFoundException("El correo no se envio");
			return ResponseEntity.ok(g.toJson(notFoundException));
		}
							
	}
	
	// http://127.0.0.1:8080/apiRest/updateUser/
	@PutMapping("/updateUser")
	public ResponseEntity<Object> update(@RequestBody User user, @PathVariable long id) {
		user.setId(id);
		
		try {
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		    Matcher matcher = pattern.matcher(user.getEmail());
		    boolean matchFound = matcher.find();
			if(matchFound) {
				return ResponseEntity.ok(this.userService.update(user, id));

			}else
			{
				Gson g = new Gson();
				NotFoundException notFoundException = new NotFoundException("El correo no es valido");
				return ResponseEntity.ok(g.toJson(notFoundException));
			}

		} catch (Exception e) {
			Gson g = new Gson();
			NotFoundException notFoundException = new NotFoundException("El correo no se envio");
			return ResponseEntity.ok(g.toJson(notFoundException));
		}
	}

	

	// http://127.0.0.1:8080/apiRest/deleteUser/1
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity< String>  deteteUser(@PathVariable int userId) {
		
		this.userService.deleteById(userId);
		String result = "Deleted user id - " + userId;

		return ResponseEntity.ok(result);
	}

}
