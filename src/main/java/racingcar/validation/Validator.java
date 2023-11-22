package racingcar.validation;

import racingcar.domain.ErrorMessage;

import static racingcar.domain.ErrorMessage.*;

public class Validator {

    public void validCount(String count) {
        checkType(count);

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
