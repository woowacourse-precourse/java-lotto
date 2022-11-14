package lotto.domain;

import static lotto.view.OutputView.printErrorMessage;

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
            System.out.println("[ERROR] 입력은 숫자만 가능합니다.");
            throw new IllegalArgumentException("[ERROR] [ERROR] 입력은 숫자만 가능합니다.");
        }
        canDivideByUnit(inputMoney);
        isEnoughMoney(inputMoney);
    }

    private void canDivideByUnit(int input) {
        if (input % PRICE_OF_LOTTO != 0) {
            printErrorMessage(String.format("[ERROR] 구매 금액은 %,d원으로 나누어 떨어져야 합니다.", PRICE_OF_LOTTO));
            throw new IllegalArgumentException();
        }
    }

    private void isEnoughMoney(int input) {
        if (input < PRICE_OF_LOTTO) {
            printErrorMessage(String.format("[ERROR] 구매 금액은 %,d원 이상이어야 합니다.", PRICE_OF_LOTTO));
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
