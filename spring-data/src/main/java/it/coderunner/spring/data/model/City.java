package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class City implements Serializable {

	// private static final long serialVersionUID = -7901094204949006824L;

	private static final long serialVersionUID = 5034408425716562074L;

	@Id //klucz głowny
	@GeneratedValue // tworzy numer id
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String country;
	
	public City(String name, String country){
		this.name = name;
		this.country = country;
	}

}