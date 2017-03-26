package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

	Page<Car> findAll(Pageable pageable);

	Page<Car> findByMakeContainingAndModelContainingAllIgnoringCase(String make, String model, Pageable pageable);

	Car findByMakeAndModelAllIgnoringCase(String make, String model);

	List<Car> findFirst10ByModel(String model);

	@SuppressWarnings("unchecked")
	Car save(Car car);

}
