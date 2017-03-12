package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Person;

public interface PersonDAO {

	public Person save(Person p);
	
	List<Person> list();

	public Person find(int p);
	
	public Person update(Person p);
		
}
