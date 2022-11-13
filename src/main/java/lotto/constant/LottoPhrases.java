package lotto.constant;

public enum LottoPhrases {

    INPUT_MONEY_PHRASES("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PHRASES("개를 구매했습니다."),
    INPUT_LOTTERY_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");

    private final String message;

    private LottoPhrases(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
