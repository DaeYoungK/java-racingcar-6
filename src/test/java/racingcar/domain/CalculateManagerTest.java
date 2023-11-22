package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculateManagerTest {

    CalculateManager calculateManager = new CalculateManager();

    @DisplayName("자동차 이름 배열을 받아 쉼표를 기준으로 나눈다.")
    @Test
    void makeListTest() {
        String names = "bong,car,apple";

        List<String> carNames = calculateManager.makeList(names);

        assertThat(carNames.size()).isEqualTo(3);
        assertThat(carNames).containsExactly("bong", "car", "apple");
    }

    @DisplayName("경주 결과를 받아 우승자를 찾는다.")
    @Test
    void getWinnersTest() {
        CarStore carStore = new CarStore();
        carStore.add("bong");
        carStore.add("bong2");
        carStore.add("bong3");
        List<Car> cars = carStore.getCars();
        cars.get(0).move(4);
        cars.get(0).move(4);
        cars.get(1).move(4);
        cars.get(1).move(4);

        List<String> winners = calculateManager.getWinners(cars);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(cars.get(0).getLevel()).isEqualTo(2);
        assertThat(winners).contains("bong", "bong2");
    }

}