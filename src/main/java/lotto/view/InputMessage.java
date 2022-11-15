package lotto.view;

public enum InputMessage {
    inputPay("구입금액을 입력해 주세요."),
    amoutOfLotto("개를 구매했습니다."),
    inputWinningNumber("당첨번호를 입력해 주세요."),
    inputBonus("보너스 번호를 입력해 주세요.");

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}