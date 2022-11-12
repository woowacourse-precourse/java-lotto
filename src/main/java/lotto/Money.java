package lotto;

public class Money {
    private final int won;

    public Money(int won) {
        this.won = won;
    }

    public Money(String input) {
        this.won = validateUnit(convertToInt(input));
    }

    public int getWon() {
        return won;
    }

    private int validateUnit(int money) {
        if (money / 1000 < 1) {
            throw new IllegalArgumentException();
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    private int convertToInt(String won) {
        try {
            return Integer.parseInt(won);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException();
        }
    }
}
