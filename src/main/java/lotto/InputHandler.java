package lotto;

import static lotto.ErrorMessages.DUPLICATE_NUMBER;
import static lotto.ErrorMessages.NOT_DIGIT;
import static lotto.ErrorMessages.OUT_OF_BOUND_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String COMMA = ",";
    private static final int MIN_AMOUNT = 1_000;
    private static final int MAX_AMOUNT = 100_000;

    public static Money readMoney() {
        String input = readLine();
        int amount = parseInt(input);
        if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(OUT_OF_BOUND_AMOUNT);
        }
        return new Money(amount);
    }

    public static Lotto readWinningNumber() {
        String input = readLine();
        return new Lotto(Arrays.stream(input.split(COMMA))
                .map(InputHandler::parseInt)
                .collect(Collectors.toList()));
    }

    public static Bonus readBonusNumber(Lotto winningNumber) {
        String input = readLine();
        int amount = parseInt(input);
        Bonus bonus = new Bonus(amount);
        if (winningNumber.getNumbers().contains(bonus.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
        return new Bonus(amount);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static int parseInt(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_DIGIT);
        }
        return result;
    }
}
