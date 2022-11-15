package lotto.domain;

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
            throw new IllegalArgumentException("로또 구매 금액은 최소 1,000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위어야 합니다.");
        }

        return money;
    }

    private int convertToInt(String won) {
        try {
            return Integer.parseInt(won);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("로또 구매 금액은 숫자로만 입력해 주세요.");
        }
    }
}
