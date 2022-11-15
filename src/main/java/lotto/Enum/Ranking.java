package lotto.Enum;

public enum Ranking {
    RANKING("당첨 통계\n---"),
    NUMBER_FIVE("3개 일치 (5,000원) - "),
    NUMBER_FOUR("4개 일치 (50,000원) - "),
    NUMBER_THREE("5개 일치 (1,500,000원) - "),
    NUMBER_TWO("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    NUMBER_ONE("6개 일치 (2,000,000,000원) - ");
    private String message;

    Ranking(String message) {
        this.message = message;
    }

    public String getMessage(int quantity) {
        return message + quantity + "개";
    }
    public String getMessage() {
        return message;
    }
}
