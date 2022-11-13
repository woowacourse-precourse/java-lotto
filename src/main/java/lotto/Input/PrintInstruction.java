package lotto.Input;

public enum PrintInstruction {
    BUY("구입금액을 입력해 주세요."),
    ENTER_NUM("당첨 번호를 입력해주세요."),
    ENTER_BONUS("보너스 번호를 입력해주세요.");
    private final String message;

    PrintInstruction (String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
