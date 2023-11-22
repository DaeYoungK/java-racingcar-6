package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ErrorApplicationTest extends NsTest {

    private static final String ERROR = "[ERROR]";

    @Test
    void 시도할_횟수가_0인지_검증() {
        assertSimpleTest(() ->
             runException("pobi,java", "0"));
             assertThat(output()).contains(ERROR);
    }

    @Test
    void 시도할_횟수가_숫자인지_검증() {
        assertSimpleTest(() ->
                runException("pobi,java", "영"));
        assertThat(output()).contains(ERROR);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
