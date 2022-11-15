package lotto.util;

public enum ResultMessage {
    LOTTO_COUNT("%d개를 구매했습니다.%n"),
    FIFTH_CORRECT_THREE("3개 일치 (5,000원) - %d개%n"),
    FOURTH_CORRECT_FOUR("4개 일치 (50,000원) - %d개%n"),
    THIRD_CORRECT_FIVE("5개 일치 (1,500,000원) - %d개%n"),
    SECOND_CORRECT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    FIRST_CORRECT_SIX("6개 일치 (2,000,000,000원) - %d개%n"),
    RATE_OF_RETURN("총 수익률은 %.1f" + "입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String printMessage() {
        return message;
    }
}
