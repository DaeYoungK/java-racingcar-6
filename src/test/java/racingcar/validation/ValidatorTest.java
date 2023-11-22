package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("입력한 데이터가 숫자인지 검증")
    @ValueSource(strings = {"qwe", "숫자", " "})
    @ParameterizedTest
    void validTypeTest(String value) {
        assertThatThrownBy(() -> validator.validCount(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 데이터가 숫자인지 검증")
    @ValueSource(strings = {"0", "00", "000"})
    @ParameterizedTest
    void validSizeTest(String value) {
        assertThatThrownBy(() -> validator.validCount(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경주용 자동차 이름이 5글자 이하인지 검증")
    @Test
    void validNameLengthTest() {
        List<String> value = Arrays.asList("김대영", "Qwe", "으라차차차차");
        assertThatThrownBy(() -> validator.validName(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경주용 자동차 이름에 빈칸 제거")
    @Test
    void validRemoveBlankTest() {
        List<String> value = Arrays.asList("김 대 영", "Q e  ", " 으  ");

        List<String> resultValues = validator.validName(value);

        assertThat(resultValues).containsExactly("김대영", "Qe", "으");
    }


}