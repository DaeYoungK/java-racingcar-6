package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("숫자를 받아 기준 이상이면 자동차 레벨이 상승한다.")
    @Test
    void moveTest() {
        String carName = "bong";
        int randomNumber = 4;
        Car newCar = Car.create(carName);

        newCar.move(randomNumber);

        assertThat(newCar).extracting("level").isEqualTo(1);
    }
}
