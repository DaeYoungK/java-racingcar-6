package racingcar.domain;

public class Car {

    private static final int INIT_CAR_LEVEL = 0;
    private static final String INIT_CAR_LOG = "";
    private int level;
    private String log;

    private Car(int level, String log) {
        this.level = level;
        this.log = log;
    }

    public static Car create() {
        return new Car(INIT_CAR_LEVEL, INIT_CAR_LOG);
    }
}
