package racingcar.domain;

public class AdvanceLog {

    private static final String ADVANCE_CHECK = "-";
    private static final String INIT_LOG = "";
    private static final String LINE = " : ";

    public String make(String carName, int level) {
        String log = INIT_LOG;
        for (int i = 0; i < level; i++) {
            log += ADVANCE_CHECK;
        }
        return carName + LINE + log;
    }
}
