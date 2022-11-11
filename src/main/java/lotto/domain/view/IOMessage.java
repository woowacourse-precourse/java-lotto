package lotto.domain.view;

public enum IOMessage {
    INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요."),
    INPUT_DESIGNATE_FIRSTPLCAE("당첨 번호를 입력해 주세요."),
    INPUT_DESIGNATE_BONUS("보너스 번호를 입력해 주세요.");

    private String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
