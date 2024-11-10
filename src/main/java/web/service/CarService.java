package web.service;

import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public interface CarService {

    public List<Car> allCars ();

    public List <Car> limitCars (int values);
}
