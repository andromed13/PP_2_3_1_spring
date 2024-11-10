package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public String cars(
            @RequestParam(name = "count", required = false, defaultValue = "0")
            int count, Model model) {
        if (count > 0 && count <5) {
            model.addAttribute("cars", carService.limitCars(count));
        } else {
            model.addAttribute("cars", carService.allCars());
        }
        return "cars";
    }
}
