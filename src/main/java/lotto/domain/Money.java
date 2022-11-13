package lotto.domain;

import java.util.regex.Pattern;

public class Money {
    public static final int STANDARD_WON = 1000;
    public static final int ZERO_WON = 0;
    public static final String NOT_MOD_ZERO_MESSAGE = "[ERROR] 1000으로 나누어지는 금액이 아닙니다.";
    public static final String REJECT_ZERO = "[ERROR] 구입 금액에 0을 입력할 수 없습니다.";
    public static final String REJECT_NOT_NUMBERS = "[ERROR] 구입 금액에 숫자를 제외한 다른 입력이 올 수 없습니다.";
    private int money;

    public Money(String input) {
        try {
            validateConsistOfNumbers(input);
            validateMoneyZero(input);
            validateMoney(input);
            this.money = Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            this.money = 0;
            System.out.println(e.getMessage());
        }
    }

    public void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if (Math.floorMod(money, STANDARD_WON) != 0) {
            throw new IllegalArgumentException(NOT_MOD_ZERO_MESSAGE);
        }
    }

    public void validateConsistOfNumbers(String input) throws IllegalArgumentException {
        boolean result = Pattern.matches("^[0-9]*$", input);
        if (!result) {
            throw new IllegalArgumentException(REJECT_NOT_NUMBERS);
        }
    }

    public void validateMoneyZero(String input) throws IllegalArgumentException {
        if (input.equals(String.valueOf(ZERO_WON))) {
            throw new IllegalArgumentException(REJECT_ZERO);
        }
    }

    public int getLottoCount() {
        return Math.floorDiv(this.money, STANDARD_WON);
    }
}
