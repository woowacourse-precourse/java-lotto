package lotto.model.enumeration;

public enum Reward {

    THREE_MATCHES("3개 일치 (5,000원) - "),
    FOUR_MATCHES("4개 일치 (50,000원) - "),
    FIVE_MATCHES("5개 일치 (1,500,000원) - "),
    FIVE_MATCHES_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - ");


    private final String message;

    Reward(String message) {
        this.message = message;
    }

    private static Reward[] rewards = Reward.values();

    public String getMessage() {
        return message;
    }
}