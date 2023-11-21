package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}