package lotto.enumeration;

public enum ConsoleAlert {
    START_ALERT("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBERS_ALERT("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_ALERT("보너스 번호를 입력해 주세요."),
    NUMBER_OF_PURCHASES_PHRASE("개를 구매했습니다."),
    RESULT_PHRASE("당첨 통계\n---"),
    RESULT_EARNING_RATE_PHRASE("총 수익률은 %.1f%%입니다.");

    private final String alertString;

    ConsoleAlert(String alertString) {
        this.alertString = alertString;
    }

    public String toAlertString() {
        return alertString;
    }

}
