package racingcar.view;

public class OutputView {

    private static final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printResultMessage(String gameResult) {
        System.out.println(gameResult);
    }

    public void printFinalWinner(String winners) {
        System.out.println(FINAL_WINNER + winners);
    }
}
