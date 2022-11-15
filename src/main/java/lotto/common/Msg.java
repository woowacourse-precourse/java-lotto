package lotto.common;

public enum Msg {
    WELCOME("구입금액을 입력해 주세요."),
    WINNING("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n" + "---\n");

    private String msg;

    Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
