package com.example.tablebooking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tablebooking.dto.RestaurantTable;
import com.example.tablebooking.exception.ResourceNotFoundException;
import com.example.tablebooking.repository.TableRepository;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "http://localhost:4200")

public class TableController {
	
	@Autowired
	private TableRepository repository;
	
	@GetMapping
	public List<RestaurantTable> getTables(){

		return repository.findAll();
	}
	
	@PostMapping("/book/{id}")
	public ResponseEntity<Map<String,String>> bookTable(@PathVariable Long id) {
		RestaurantTable table = repository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("table not Found with table id: "+id));
		Map<String,String> response=new HashMap<>();
//		if(table==null) {
//			response.put("message", "table not found");
//			return ResponseEntity.ok(response);
//		}
		if(table.isBooked()) {
			response.put("message", "Table is already booked");
			return ResponseEntity.ok(response);
		}
		table.setBooked(true);
		repository.save(table);
		response.put("message", "Table Booked Successfully");
		return ResponseEntity.ok(response);
		
	}
	
	
	@PostMapping("/cancel/{id}")
	public ResponseEntity<Map<String,String>> cancelBooking(@PathVariable Long id){
		RestaurantTable tables = repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Table with given Id not Found"+ id));
		Map<String,String> response= new HashMap<>();
//		if(tables==null) {
//			response.put("message", "Table Not Found");
//			return ResponseEntity.ok(response);
//		}
		if(!tables.isBooked()) {
			response.put("message", "Table Already Booked");
			return ResponseEntity.ok(response);
		}
		tables.setBooked(false);
		repository.save(tables);
		response.put("message", "Table Booking Cancelled");
		return ResponseEntity.ok(response);
	}
	
	

}
