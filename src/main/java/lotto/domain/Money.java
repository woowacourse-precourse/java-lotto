package lotto.domain;

import lotto.Message;
import static lotto.Message.*;
import java.util.regex.Pattern;

public class Money {
    public static final int STANDARD_WON = 1000;
    private final int money;
    private final int lottoCount;

    public Money(String input) throws IllegalArgumentException {
        validateConsistOfNumbers(input);
        validateMoneyZero(input);
        validateMoney(input);
        this.money = Integer.parseInt(input);
        this.lottoCount = Math.floorDiv(this.money, STANDARD_WON);
    }

    public void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if (Math.floorMod(money, STANDARD_WON) != 0) {
            throw new IllegalArgumentException(NOT_MOD_ZERO_MESSAGE.getValue());
        }
    }

    public void validateConsistOfNumbers(String input) throws IllegalArgumentException {
        boolean result = Pattern.matches("^[0-9]*$", input);
        if (!result) {
            throw new IllegalArgumentException(REJECT_NOT_NUMBERS.getValue());
        }
    }

    public void validateMoneyZero(String input) throws IllegalArgumentException {
        if (String.valueOf(input.charAt(0)).equals("0")) {
            throw new IllegalArgumentException(Message.REJECT_ZERO.getValue());
        }
    }

    public int getMoney() {
        return this.money;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
