package com.ContactManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ContactManager.entity.ContactEntity;
import com.ContactManager.repository.AppRepository;

@Service
public class AppService {

	@Autowired
	private AppRepository repo;
	
	public List<ContactEntity> getContacts() {
		return repo.findAll();
	}

	public void saveContact(ContactEntity contact) {
		repo.save(contact);
	}

	public ContactEntity getContactById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public String updateContact(Long id, ContactEntity updatedContact) {
		Optional<ContactEntity> optional = repo.findById(id);
		if(optional.isPresent()) {
			ContactEntity newContact = optional.get();
			newContact.setName(updatedContact.getName());
			newContact.setPhone(updatedContact.getPhone());
			newContact.setAddress(updatedContact.getAddress());
			newContact.setEmail(updatedContact.getEmail());
			repo.save(newContact);
			return "contact updated successfully";
		}else {
			return "contact not found";
		}
	}

	public String deleteContact(Long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "contact deleted successfully";
		}else {
			return "contact not found";
		}
	}

	
	
}
