package lotto.data;

public enum InputForm {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS( "당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    InputForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
