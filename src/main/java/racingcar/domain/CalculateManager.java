package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateManager {

    private static final int OR_ELSE_NUMBER = 0;
    private static final String SEPARATOR = ",";

    public List<String> makeList(String names) {
        return Arrays.stream(names.split(SEPARATOR)).toList();
    }

    public List<String> getWinners(List<Car> cars) {

        int maxLevel = getMaxLevel(cars);

        return setWinners(cars, maxLevel);
    }

    private List<String> setWinners(List<Car> cars, int maxLevel) {
        List<String> carNames = new ArrayList<>();
        cars.stream().filter(car -> car.getLevel() == maxLevel).forEach(car -> carNames.add(car.getCarName()));

        return carNames;
    }

    private int getMaxLevel(List<Car> cars) {
        return cars.stream().mapToInt(v -> v.getLevel()).max().orElse(OR_ELSE_NUMBER);
    }
}
