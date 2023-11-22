package racingcar.domain;

import java.util.List;

public class AdvanceLog {

    private static final String ADVANCE_CHECK = "-";
    private static final String INIT_LOG = "";
    private static final String LINE = " : ";
    private static final String SEPARATOR = ", ";
    private static final String NEXT_LINE = "\n";
    private static final int ONLY_ONE_WINNER = 1;
    private static final int ONLY_ONE_WINNER_INDEX = 0;

    public String make(String carName, int level) {
        String log = INIT_LOG;
        for (int i = 0; i < level; i++) {
            log += ADVANCE_CHECK;
        }
        return carName + LINE + log + NEXT_LINE;
    }

    public String winners(List<String> winners) {
        if (winners.size() == ONLY_ONE_WINNER) {
            return winners.get(ONLY_ONE_WINNER_INDEX);
        }

        return String.join(SEPARATOR, winners);
    }
}
