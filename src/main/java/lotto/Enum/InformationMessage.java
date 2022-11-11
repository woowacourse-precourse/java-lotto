package lotto.Enum;

public enum InformationMessage {
    INPUT_AMOUNT_OF_MONEY_TO_BUY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_WINNING_NUMBER("보너스 번호를 입력해 주세요."),
    COUNT_OF_LOTTO("개를 구매했습니다.");


    private String message;

    private InformationMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
