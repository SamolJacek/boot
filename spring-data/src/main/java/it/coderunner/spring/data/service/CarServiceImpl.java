package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.CarRepository;
import it.coderunner.spring.data.model.Car;

@Service
public class CarServiceImpl implements CarService{

	private static final long serialVersionUID = -3674691982561210039L;
	
	@Resource
	private CarRepository carRepository;

	@Override
	public Car findByMakeAndModelAllIgnoringCase(String make, String model) {
		return carRepository.findByMakeAndModelAllIgnoringCase(make, model);
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public List<Car> findFirst10ByModel(String model) {
		return carRepository.findFirst10ByModel(model);
	}

	@Override
	public Page<Car> findAll(Pageable pageable) {
		return carRepository.findAll(pageable);
	}
	
	
}
