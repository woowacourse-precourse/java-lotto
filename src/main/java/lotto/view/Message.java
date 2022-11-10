package lotto.view;

import static lotto.view.Buyer.purchaseLottoCount;

public enum Message {
    PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("개를 구매했습니다."),
    WINNING_NUMBER_INPUT("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계"),
    LINES("---"),
    THREE_MATCHES("3개 일치 (5,000원) - "),
    FOUR_MATCHES("4개 일치 (50,000원) - "),
    FIVE_MATCHES("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    ALL_MATCHES("6개 일치 (2,000,000,000원) - "),
    TOTAL_YIELDS("총 수익률은 %입니다.");

    final private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    static void printWinningHistroy() {
        System.out.println(WINNING_STATS);
        System.out.println(LINES);
        System.out.println(THREE_MATCHES + "" + "개");
        System.out.println(FOUR_MATCHES + "" + "개");
        System.out.println(FIVE_MATCHES + "" + "개");
        System.out.println(FIVE_BONUS_MATCHES + "" + "개");
        System.out.println(ALL_MATCHES + "" + "개");
        System.out.println(TOTAL_YIELDS);
    }
}
