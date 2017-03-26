package it.coderunner.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.coderunner.spring.data.model.Car;
import it.coderunner.spring.data.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/get/car/{make}/{model}")
	public @ResponseBody ResponseEntity<String> getByMakeAndModel(@PathVariable String make, //zmienna musi miec ta sama nazwe w mappingu co w parametrze funkcji
			@PathVariable String model) {
		Car car = carService.findByMakeAndModelAllIgnoringCase(make, model);
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("No car found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/car/{make}/{model}")
	public @ResponseBody ResponseEntity<String> saveCar(@PathVariable String make, @PathVariable String model) {
		Car car = carService.save(new Car(make, model));
		return car != null ? new ResponseEntity<String>("GET Response : " + car, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

//	@GetMapping("/get/top10/{country}")
//	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String country) {
//		List<City> cities = cityService.findFirst10ByCountry(country);
//		cities.stream().forEach(System.out::println);
//		return cities != null && !cities.isEmpty()
//				? new ResponseEntity<String>("GET Response : " + cities, HttpStatus.OK)
//				: new ResponseEntity<String>("No city found", HttpStatus.NOT_FOUND);
//	}

	@GetMapping("/get/allCar/{page}/{size}")
	public @ResponseBody Page<Car> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return carService.findAll(new PageRequest(page, size));
	}


}
