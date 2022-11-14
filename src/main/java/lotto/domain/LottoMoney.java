package lotto.domain;

public class LottoMoney {
    private int money;
    private int quantity;

    public void inputMoney(String input) {
        validateNumber(input);
        money = toInt(input);
        validateDivided();
        quantity = money / 1000;
    }

    private void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Error.IS_NOT_NUMBER.getMessage());
        }
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateDivided() {
        if ((money % 1000 != 0) || (money / 1000 == 0)) {
            throw new IllegalArgumentException(Error.IS_NOT_DIVIDED.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return quantity;
    }
}
