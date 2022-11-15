package lotto.domain;

import lotto.Message;
import static lotto.Message.*;
import java.util.regex.Pattern;

public class Money {
    private static final int STANDARD_WON = 1000;
    private static final int NULL = 0;
    private final int money;
    private final int lottoCount;

    public Money(String input) throws IllegalArgumentException {
        validateNotNull(input);
        validateConsistOfNumbers(input);
        validateMoneyZero(input);
        validateMoney(input);
        this.money = Integer.parseInt(input);
        this.lottoCount = Math.floorDiv(this.money, STANDARD_WON);
    }

    private void validateNotNull(String input) {
        if(input.length() == NULL) {
            throw new IllegalArgumentException(REQUIRE_INPUT.getValue());
        }
    }

    private void validateMoney(String input) {
        int money = Integer.parseInt(input);
        if (Math.floorMod(money, STANDARD_WON) != 0) {
            throw new IllegalArgumentException(NOT_MOD_ZERO_MESSAGE.getValue());
        }
    }

    private void validateConsistOfNumbers(String input) throws IllegalArgumentException {
        boolean result = Pattern.matches("^[0-9]*$", input);
        if (!result) {
            throw new IllegalArgumentException(REJECT_NOT_NUMBERS.getValue());
        }
    }

    private void validateMoneyZero(String input) throws IllegalArgumentException {
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
