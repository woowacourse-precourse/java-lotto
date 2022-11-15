package lotto.resource;


public enum WinningType {
    THREE("3개 일치 (%s원) - %d개",
            3, 5_000),
    FOUR("4개 일치 (%s원) - %d개",
            4, 50_000),
    FIVE("5개 일치 (%s원) - %d개",
            5, 1_500_000),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개",
            6, 30_000_000),
    SIX("6개 일치 (%s원) - %d개",
            7, 2_000_000_000);

    private final String message;
    private final int numberOfMatching;
    private final int money;

    WinningType(String message, int numberOfMatching, int money) {
        this.message = message;
        this.numberOfMatching = numberOfMatching;
        this.money = money;
    }

    public String getMessage() {
        return message;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getMoney() {
        return money;
    }
}
