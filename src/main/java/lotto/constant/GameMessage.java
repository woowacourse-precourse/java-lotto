package lotto.constant;

public enum GameMessage {
    ASK_FOR_INITIAL_MONEY("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE("\n%d개를 구매했습니다."),
    ASK_FOR_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    ASK_FOR_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    RESULT_HEADER("\n당첨 통계\n---"),
    RESULT_BODY("%d개 일치%s (%,d원) - %d개"),
    BONUS_BODY(", 보너스 볼 일치"),
    EMPTY(""),
    PROFIT_RATE("총 수익률은 %,.1f%%입니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int formatNumber) {
        return String.format(message, formatNumber);
    }

    public String getMessage(double formatNumber) {
        return String.format(message, formatNumber);
    }

    public String getMessage(PrizeStatistic prizeType, int count) {
        int matchingNumbers = prizeType.getMatchingNumbers();
        boolean bonus = prizeType.geBonus();
        long prizeAmount = prizeType.getPrizeAmount();
        if (bonus) {
            return String.format(message, matchingNumbers, BONUS_BODY.message, prizeAmount, count);
        }
        return String.format(message, matchingNumbers, EMPTY.message, prizeAmount, count);
    }
}
