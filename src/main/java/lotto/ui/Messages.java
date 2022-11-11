package lotto.ui;

public enum Messages {
    INPUT_MONEY("구입금액을 입력해 주세요"),
    INPUT_LOTTE_NUMBER("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
