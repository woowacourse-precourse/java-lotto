package lotto.model;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_PRICE_ERROR = "[ERROR] 잘못된 가격을 입력하셨습니다.";

    public int changeToLotto(String moneyInput) {
        validate(moneyInput);

        int money = Integer.parseInt(moneyInput);
        return money / LOTTO_PRICE;
    }

    private void validate(String input) {
        String regex = "^[0-9]{1,}000$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(INPUT_PRICE_ERROR);
        }
    }
}
