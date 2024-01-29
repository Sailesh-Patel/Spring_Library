package com.lbg.demo.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.library.domain.Person;
import com.lbg.demo.library.repos.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	// post mapping 'create'
	public ResponseEntity<Person> createPerson(Person newPerson) {
		Person created = this.repo.save(newPerson);
		return new ResponseEntity<Person>(created, HttpStatus.CREATED);
	}

	// get mapping by id 'get/id'
	public ResponseEntity<Person> getPerson(int id) {
		Optional<Person> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		Person body = found.get();
		return ResponseEntity.ok(body);
	}

	// get mapping for 'get all'
	public List<Person> getPersons() {
		return this.repo.findAll();
	}

	// delete mapping for 'remove by id'
	public boolean remove(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// put mapping for 'update by id'

	public ResponseEntity<Person> update(int id, Person newPerson) {
		Optional<Person> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Person existing = found.get();
		if (newPerson.getName() != null) {
			existing.setName(newPerson.getName());
		}
		Person updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

}
