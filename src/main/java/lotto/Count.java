package lotto;

public class Count {
    static final int MONEY_UNIT = 1000;
    static final int REMAINDER_ZERO = 0;

    private final int numOfLotto;

    public Count(String price) {
        validPriceOfLotto(price);
        numOfLotto = calculateNumOfLotto(Integer.parseInt(price));
    }

    private int validPriceOfLotto(String priceOfLotto) {
        try {
            return Integer.parseInt(priceOfLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private int calculateNumOfLotto(int priceOfLotto) {
        if (priceOfLotto%MONEY_UNIT==REMAINDER_ZERO) {
            return priceOfLotto/MONEY_UNIT;
        }
        throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
    }
}
