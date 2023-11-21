package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CalculateManager {

    public List<String> makeList(String names) {
        return Arrays.stream(names.split(",")).toList();
    }
}
