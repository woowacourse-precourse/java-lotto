package lotto.view.controller;

public enum ConsoleMessage {
    INPUT_BUY_MONEY("구입금액을 입력해 주세요."),
    PRINT_BUY("를 구매했습니다."),
    INPUT_CORRECT_LOTTO_MONEY("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_LOTTO_STATISTICS("당첨 통계"),
    PARTITION_LINE("---"),
    PRINT_FRONT_TOTAL_RETURN_RATE("총 수익률은 "),
    PRINT_BACK_TOTAL_RETURN_RATE("%입니다."),
    NUMBER_COUNT_UNITS("개");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
