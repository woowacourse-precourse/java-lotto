package lotto;

public class Count {
    private final int numOfLotto;

    public Count(String price) {
        validPriceOfLotto(price);
        numOfLotto = Integer.parseInt(price);
    }

    private int validPriceOfLotto(String priceOfLotto) {
        try {
            return Integer.parseInt(priceOfLotto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
