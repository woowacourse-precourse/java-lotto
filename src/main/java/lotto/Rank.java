package lotto;

public enum Rank {
    FIFTH("3개 일치 ", 5000),
    FOURTH("4개 일치 ", 50000),
    THIRD("5개 일치 ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 ", 30000000),
    FIRST("6개 일치 ", 2000000000);

    private final String message;
    private final int price;

    Rank(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }
}
