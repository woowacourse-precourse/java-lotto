package lotto.view;// @ author ninaaano

public enum InputView {
    BUYLOTTO_MESSAGE("구입금액을 입력해 주세요."),
    BUY_RESUIT_MESSAGE("개를 구매했습니다."),
    INPUTNUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUTBONUSNUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    LINES("---"),
    WINNING_MESSAGE("당첨 통계"),
    YIELD_MESSAGE("총 수익률은 %.1f%%입니다");

    private String message;

    InputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
