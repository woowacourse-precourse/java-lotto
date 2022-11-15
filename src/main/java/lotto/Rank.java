package lotto;

public enum Rank {

    FIRST("1등", 6, 2000000000),
    SECOND("2등", 7, 30000000),
    THIRD("3등", 5, 1500000),
    FOURTH("4등", 4, 50000),
    FIFTH("5등", 3, 5000);

    private final String message;
    private final int wins;
    private final int price;

    Rank(String message, int wins, int price) {
        this.message = message;
        this.wins = wins;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public int getWins() {
        return wins;
    }

    public int getPrice() {
        return price;
    }

}
