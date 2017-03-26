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
public class Car implements Serializable{

	private static final long serialVersionUID = -4195304285341682099L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column (nullable = false)
	private String make;
	
	@Column (nullable = false)
	private String model;
	
	public Car(String make, String model){
		this.make = make;
		this.model = model;
	}
}
