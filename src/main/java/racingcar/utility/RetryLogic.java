package racingcar.utility;

import racingcar.domain.ErrorMessage;

import static racingcar.domain.ErrorMessage.*;

public class RetryLogic {

    private static final int MAX_RETRY_COUNT = 5;
    private static final String TIME_OUT = "최대 시도 횟수가 초과되었습니다.";

    public static void retry(Retry retry) {
        for (int i = 1; i <= MAX_RETRY_COUNT; i++) {
            if (isRetry(retry, i)) break;
        }
    }

    private static boolean isRetry(Retry retry, int i) {
        try {
            retry.run();
            return true;
        }catch (Exception e) {
            if (i == MAX_RETRY_COUNT) {
                System.out.println(TIME_OUT);
                throw e;
            }
            checkEx(e);
        }
        return false;
    }

    private static void checkEx(Exception e) {
        if (!(e.getClass().isAssignableFrom(IllegalArgumentException.class))) {
            message(COMMON_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
