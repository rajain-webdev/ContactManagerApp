package com.ContactManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ContactManager.entity.ContactEntity;
import com.ContactManager.repository.AppRepository;
import com.ContactManager.service.AppService;

import jakarta.validation.Valid;
import lombok.Delegate;

@RestController
@RequestMapping("/contacts")
public class AppController {

	@Autowired
	private AppService service;
	
	@GetMapping("/getAllContacts")
	public List<ContactEntity> getAllContact() {
		return service.getContacts();
	}
	
	@PostMapping("/addContact")
	public String addContact(@Valid @RequestBody ContactEntity contact) {
		service.saveContact(contact);
		return "contact added successfully";
	}
	
	@GetMapping("/getContact/{id}")
	public ContactEntity getContactById(@PathVariable Long id) {
		return service.getContactById(id);
	}
	
	@PutMapping("/updateContact/{id}")
	public String updateContact(@Valid @PathVariable Long id, @RequestBody ContactEntity updatedContact) {
		return service.updateContact(id, updatedContact);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Long id) {
		return service.deleteContact(id);
	}
	
}
