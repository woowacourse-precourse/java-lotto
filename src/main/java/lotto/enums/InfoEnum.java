package lotto.enums;

public enum InfoEnum {
    MONEY("구매금액을 입력해 주세요."),
    BUY_NUMBER("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    public String getMessage() {
        return message;
    }

    InfoEnum(String message) {
        this.message = message;
    }
}
