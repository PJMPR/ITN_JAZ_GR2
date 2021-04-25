package com.example.demo.controllers;

import com.example.demo.contract.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("homework")
public class PersonController {

	@GetMapping("{path}")
	public ResponseEntity getPathAndParam(@PathVariable("path") String path, @PathParam("query") String query) {
		return ResponseEntity.ok("path:" + path + " query:" + query);
	}

	@PostMapping("person")
	public ResponseEntity postPerson(@RequestBody Person person) {
		return ResponseEntity.ok(person);
	}

	@PutMapping("person/{id}")
	public ResponseEntity updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
		return ResponseEntity.ok(person);
	}

	@DeleteMapping("person/{id}")
	public ResponseEntity deletePerson(@PathVariable("id") String id) {
		return ResponseEntity.ok("");
	}

}
