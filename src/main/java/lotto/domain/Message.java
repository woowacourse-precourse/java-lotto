package lotto.domain;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    BUY_SOME("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WIN_RATE("당첨 통계"),
    LINE("---"),
    CORRECT_THIRD("3개 일치 (5,000원) - "),
    CORRECT_FOURTH("4개 일치 (50,000원) - "),
    CORRECT_FIFTH("5개 일치 (1,500,000원) - "),
    CORRECT_FIFTH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_SIXTH("6개 일치 (2,000,000,000원) - " ),
    UNIT("개"),
    RETURN_OF_RATE("총 수익률은 "),
    PERCENTAGE("%입니다."),
    ERROR_MESSAGE_OVER_SIZE_LOTTO("[ERROR] 로또 번호의 크기가 초과되었습니다."),
    ERROR_MESSAGE_DUPLICATION_LOTTO("[ERROR] 중복된 수가 입력되었습니다."),
    ERROR_MESSAGE_OVER_RANGE_LOTTO("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_MESSAGE_INVALID_INPUT_NUMBER("[ERROR] 숫자를 입력하세요"),
    ERROR_MESSAGE_INVALID_INPUT_MONEY_1000_UNIT("[ERROR] 1000원 단위로 입력하세요.");


    private final String message;
    Message(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
