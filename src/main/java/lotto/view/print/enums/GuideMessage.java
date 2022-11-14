package lotto.view.print.enums;

public enum GuideMessage {
    AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요. (1,000원 단위)"),
    PURCHASE_MESSAGE("%n%d개를 구매했습니다.%n"),
    WINNINGS_INPUT_MESSAGE("\n당첨 번호를 입력해 주세요. (당첨 번호는 1 ~ 45 숫자 6개 이고, 쉼표(,)를 기준으로 공백없이 구분해주세요.)"),
    BONUS_INPUT_MESSAGE("\n보너스 번호를 입력해 주세요. (보너스 번호는 1개 이고, 1 ~ 45 숫자 입니다.)"),
    STATISTICS_MESSAGE("\n당첨 통계\n---");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}