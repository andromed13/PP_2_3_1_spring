package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("BMW", "Black", 100000));
        cars.add(new Car("Lada", "Eggplant", 10000));
        cars.add(new Car("Volvo", "Blue", 90000));
        cars.add(new Car("Audi", "Silver", 110000));
        cars.add(new Car("Toyota", "Red", 70000));
    }
    @Override
    public List <Car> allCars () {
        return cars;
    }
    @Override
    public List <Car> limitCars (int count) {
        return  cars.stream().limit(count).collect(Collectors.toList());
    }
}
