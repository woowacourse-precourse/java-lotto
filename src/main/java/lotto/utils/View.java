package lotto.utils;

public class View {
    private static final String REQUEST_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private static final String PUBLISH_LOTTO_MESSAGE = "개를 구매했습니다.";


    public static void printPriceMessage() {
        System.out.println(REQUEST_PRICE_MESSAGE);
    }

    public static void printWinningLottoMessage() {
        System.out.println("\n"+REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n"+REQUEST_BONUS_NUMBER);
    }
}
