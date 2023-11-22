package racingcar.validation;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.ErrorMessage.*;

public class Validator {

    private static final int ZERO = 0;
    private static final int STANDARD_NAME_LENGTH = 5;

    public int validCount(String count) {
        int resultCount = checkType(count);
        checkZero(resultCount);

        return resultCount;
    }

    public List<String> validName(List<String> names) {
        checkLength(names);

        return removeBlank(names);
    }

    private List<String> removeBlank(List<String> names) {
        List<String> resultNames = new ArrayList<>();
        names.stream().forEach(name -> {
            resultNames.add(name.replaceAll(" ", ""));
        });

        return resultNames;
    }

    private void checkLength(List<String> names) {
        names.stream().forEach(name -> {
            if (isLength(name)) {
                message(LENGTH_ERROR);
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean isLength(String name) {
        return name.length() > STANDARD_NAME_LENGTH;
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
