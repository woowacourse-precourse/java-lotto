package lotto.model;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;

    public int changeToLotto(String moneyInput) {
        validate(moneyInput);
        int money = Integer.parseInt(moneyInput);
        return money / LOTTO_PRICE;
    }

    private void validate(String input) {
        // TODO: 1000원 단위로 나누어 떨어지는지는 가격인지에 대한 검증이 필요
    }
}
