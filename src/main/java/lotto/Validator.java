package lotto;

public class Validator {

    public void validateMoneyInput(int money) {
        if (money % 1000 != 0) {

            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
