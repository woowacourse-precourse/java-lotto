package lotto;

public class Count {
    static final int MONEY_UNIT = 1000;
    static final int REMAINDER_ZERO = 0;

    private final int numOfLotto;
    private final int purchase;

    public Count(String price) {
        numOfLotto = calculateNumOfLotto(validPriceOfLotto(price));
        this.purchase = Integer.valueOf(price);
    }

    private int validPriceOfLotto(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private int calculateNumOfLotto(int price) {
        if (price%MONEY_UNIT==REMAINDER_ZERO) {
            return price/MONEY_UNIT;
        }
        throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
    }

    public int getNumOfLotto() {
        return numOfLotto;
    }

    public int getPurchase() {
        return purchase;
    }
}
