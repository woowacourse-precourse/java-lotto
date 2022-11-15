package lotto.ExceptionChecker;

import java.util.NoSuchElementException;

public class MoneyInputChecker {

    private final int money;
    private static final int THOUSAND = 1000;


    public MoneyInputChecker(int moneyInput) {
        validateUnit(moneyInput);

        this.money = moneyInput;
    }

    public int getMoney() {
        return money;
    }


    public void validateUnit(int moneyInput) {
        try {
            if (moneyInput % THOUSAND != 0) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 1000원 단위로 입력해주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }
}
