package racingcar.utility;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public int make() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}