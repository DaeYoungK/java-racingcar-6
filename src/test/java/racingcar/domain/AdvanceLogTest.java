package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdvanceLogTest {

    AdvanceLog advanceLog = new AdvanceLog();

    @DisplayName("레벨을 받아 자동차마다 전진을 표시한다.")
    @Test
    void checkAdvance() {
        int level = 3;
        String carName = "bong";

        String log = advanceLog.make(carName, level);

        Assertions.assertThat(log).isEqualTo("bong : ---\n");
    }

    @DisplayName("우승자 목록을 받아 우승자를 출력한다.")
    @Test
    void winnerLogTest() {
        List<String> winners = Arrays.asList("bong", "bong2");

        String winnersForPrint = advanceLog.winners(winners);

        Assertions.assertThat(winnersForPrint).isEqualTo("bong, bong2");
    }

}