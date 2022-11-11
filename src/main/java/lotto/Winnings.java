package lotto;

public enum Winnings {
    오천(5000), 오만(50000), 백오십만(1500000), 삼천만(30000000), 이십억(2000000000);

    private final int amount;

    Winnings(int amount) {
        this.amount = amount;
    }

    public int winnings() {
        return amount;
    }
}

