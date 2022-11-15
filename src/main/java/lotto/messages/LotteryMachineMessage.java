package lotto.messages;

public enum LotteryMachineMessage {
    PURCHASED_LOTTERY_NUMBER_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    RATE_OF_RETURN_MESSAGE_PREFIX("총 수익률은 "),
    RATE_OF_RETURN_MESSAGE_POSTFIX("%입니다.");

    String message;

    LotteryMachineMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
