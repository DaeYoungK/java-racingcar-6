package racingcar.validation;

import racingcar.domain.ErrorMessage;

import static racingcar.domain.ErrorMessage.*;

public class Validator {

    private static final int ZERO = 0;

    public void validCount(String count) {
        int resultCount = checkType(count);
        checkZero(resultCount);
    }

    private void checkZero(int count) {
        if (count == ZERO) {
            message(SIZE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private int checkType(String count) {
        Integer resultCount;
        try {
            resultCount = Integer.parseInt(count);
        }catch (NumberFormatException e) {
            message(COMMON_ERROR);
            throw new IllegalArgumentException(e);
        }
        return resultCount;
    }
}
