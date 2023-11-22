package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("입력한 데이터가 숫자인지 검증")
    @ValueSource(strings = {"qwe", "숫자", " "})
    @ParameterizedTest
    void validTypeTest(String value) {
        assertThatThrownBy(() -> validator.validCount(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}