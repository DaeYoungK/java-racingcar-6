package racingcar.domain;

public class Car {

    private static final int INIT_CAR_LEVEL = 0;
    private static final String INIT_CAR_LOG = "";

    private String carName;
    private int level;
    private String log;

    private Car(String carName, int level, String log) {
        this.carName = carName;
        this.level = level;
        this.log = log;
    }

    public static Car create(String carName) {
        return new Car(carName, INIT_CAR_LEVEL, INIT_CAR_LOG);
    }
}
