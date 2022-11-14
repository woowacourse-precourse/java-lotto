package lotto.domain;

public class Money {
    private final int PRICE_OF_LOTTO = 1_000;
    private int money;

    public Money(String input) {
        validate(input);
        this.money = convertToMoney(input);
    }

    private void validate(String input) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
        canDivideByUnit(inputMoney);
        isEnoughMoney(inputMoney);
    }

    private void canDivideByUnit(int input) {
        if (input % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isEnoughMoney(int input) {
        if (input < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private int convertToMoney(String input) {
        return Integer.parseInt(input);
    }

    public int numberOfTickets() {
        return this.money / PRICE_OF_LOTTO;
    }

    public int money() {
        return this.money;
    }
}
