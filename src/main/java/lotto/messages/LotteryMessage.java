package lotto.messages;

public enum LotteryMessage {
    PURCHASED_LOTTERY_NUMBER_MESSAGE("개를 구매했습니다.");

    String message;

    LotteryMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
