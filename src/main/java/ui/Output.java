package ui;

public class Output {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String THREE_WINNING = "3개 일치 (5,000원) - ";
    private static final String FOUR_WINNING = "4개 일치 (50,000원) - ";
    private static final String FIVE_WINNING = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_WINNING = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_WINNING = "6개 일치 (2,000,000,000원) - ";

    void printPriceInputMessage() {
        System.out.println(PRICE_INPUT_MESSAGE);
    }

    void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println(purchaseQuantity + "개를 구매했습니다");
    }
}
