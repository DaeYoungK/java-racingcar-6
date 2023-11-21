package racingcar.domain;

public class Car {

    private static final int STANDARD_MOVE_NUMBER = 4;
    private static final int INIT_CAR_LEVEL = 0;

    private String carName;
    private int level;

    private Car(String carName, int level) {
        this.carName = carName;
        this.level = level;
    }


    public static Car create(String carName) {
        return new Car(carName, INIT_CAR_LEVEL);
    }

    public String getCarName() {
        return carName;
    }

    public void move(int number) {
        if (isMove(number)) {
            level++;
        }
    }

    private boolean isMove(int number) {
        return number >= STANDARD_MOVE_NUMBER;
    }
}
