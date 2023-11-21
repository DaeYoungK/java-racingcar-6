package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarStore {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void add(String carName) {
        Car newCar = Car.create(carName);
        cars.add(newCar);
    }
}
