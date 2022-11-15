package lotto;

import java.awt.print.Pageable;
import java.util.NoSuchElementException;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Money {
    public static final String ERROR_MONEY = "[ERROR] 금액은 1 이상의 자연수여야 합니다.";
    public static final String ERROR_EMPTY = "[ERROR] 금액은 공백 또는 빈 문자열이 없어야 합니다.";
    public static final String ERROR_NOT_INT_MONEY = "[ERROR] 금액은 숫자로 입력해주세요.";
    private final int money;

    public Money(int money) {
        validMoney(money);
        this.money = money;
    }

    private void validMoney(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }

    public static int init() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = readLine();
        validateEmpty(userInput);
        return changeInt(userInput);
    }

    private static void isDigitCheck(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                throw new IllegalArgumentException(ERROR_NOT_INT_MONEY);
            }
        }
    }

    public static int changeInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INT_MONEY);
        }
    }

    private static void validateEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }
    }

    public int lottoAccount(Money amount) {
        return money / amount.money;
    }

    public int get() {
        return money;
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
