package lotto.game.view;

import lotto.util.Constant;

public enum Message {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_DRAW_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_LOTTO_NUMBERS("개를 구매했습니다."),
    OUTPUT_MATCH_TOTAL("당첨 통계"),
    OUTPUT_THREE_MATCHES("3개 일치 ("
            + String.format("%,d", Constant.THREE_MATCHES_PRIZE) + "원) - "),
    OUTPUT_FOUR_MATCHES("4개 일치 ("
            + String.format("%,d", Constant.FOUR_MATCHES_PRIZE) + "원) - "),
    OUTPUT_FIVE_MATCHES("5개 일치 ("
            + String.format("%,d", Constant.FIVE_MATCHES_PRIZE) + "원) - "),
    OUTPUT_BONUS_MATCHES("5개 일치, 보너스 볼 일치 ("
            + String.format("%,d", Constant.BONUS_MATCHES_PRIZE) + "원) - "),
    OUTPUT_SIX_MATCHES("6개 일치 ("
            + String.format("%,d", Constant.SIX_MATCHES_PRIZE) + "원) - "),
    OUTPUT_EARNINGS_RATE_PREFIX("총 수익률은 "),
    OUTPUT_EARNINGS_RATE_POSTFIX("입니다.");

    private final String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
