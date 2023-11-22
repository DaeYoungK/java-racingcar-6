package racingcar.utility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RetryLogicTest {

    int count = 0;

    @Test
    void retryTest() {
        assertThatThrownBy(() -> RetryLogic.retry(() -> plusCount()))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(count).isEqualTo(5);

    }

    private void plusCount() {
        count++;
        throw new IllegalArgumentException();
    }


}