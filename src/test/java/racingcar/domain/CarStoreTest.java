package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarStoreTest {

    CarStore carStore = new CarStore();

    @DisplayName("자동차의 이름을 받아 리스트에 저장한다.")
    @Test
    void addCarStore() {
        String carName = "bong";

        carStore.add(carName);
        List<Car> cars = carStore.getCars();
        Car car = cars.get(0);
        String savedCarName = car.getCarName();

        Assertions.assertThat(savedCarName).isEqualTo(carName);
    }

}