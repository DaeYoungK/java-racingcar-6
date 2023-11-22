package racingcar.domain;

public enum ErrorMessage {

    COMMON_ERROR("유효한 데이터가 아닙니다. 다시 입력해주세요."),
    SIZE_ERROR("0은 입력할 수 없습니다."),
    LENGTH_ERROR("자동차 이름은 5글자 이하로 해주세요.")
    ;

    private static final String ERROR = "[ERROR]";
    private static final String BLANK = " ";
    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public static void message(ErrorMessage errorMessage) {
        System.out.println(ERROR + BLANK + errorMessage.description);
    }
}
