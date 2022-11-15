package lotto.printer;

public enum PrinterText {

    REQUEST_BUY_CASH_UNIT("구입금액을 입력해 주세요."),
    REQUEST_WINNER_NUMBER("\n당첨 번호를 입력해 주세요."),

    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String text;


    PrinterText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    
}
