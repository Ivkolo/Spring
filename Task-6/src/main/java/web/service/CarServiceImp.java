package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImp implements CarService{

    @Override
    public List<Car> carList(Integer count) {
        List<Car> carList;
        {
            carList = new ArrayList<>();
            carList.add(new Car("Toyota", "Camry", 2022));
            carList.add(new Car("Volkswagen", "Polo", 2010));
            carList.add(new Car("Kia", "Rio", 2020));
            carList.add(new Car("Hyundai", "Solaris", 2015));
            carList.add(new Car("Renault ", "Logan", 2017));
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
