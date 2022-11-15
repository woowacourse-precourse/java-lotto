package lotto.domain.enums;

public enum BuyerPrint {
    ENTER_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PRINT_LOTTO_DATA("개를 구매했습니다.");
    private String printMessage;

    BuyerPrint(String printMessage) {
        this.printMessage = printMessage;
    }
}
