package lotto.domain;

public enum Result {
    THREE("3개 일치", "5,000", 30),
    FOUR("4개 일치", "50,000", 40),
    FIVE("5개 일치", "1,500,000", 50),
    FIVEWITHBONUS("5개 일치, 보너스 볼 일치", "30,000,000", 51),
    SIX("6개 일치", "2,000,000,000", 60);

    private final String message;
    private final String money;
    private final int score;

    Result(String message, String money, int score) {
        this.message = message;
        this.money = money;
        this.score = score;
    }
}
