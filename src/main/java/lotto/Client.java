package lotto;

import java.util.Arrays;
import java.util.List;

public class Client {


    private ClientInput clientInput;

    Client(ClientInput clientInput) {
        this.clientInput = clientInput;
    }

    public int buy() {
        String moneyAmountString = clientInput.get();

        int moneyAmount = parseStringToIntOrElseThrow(moneyAmountString);

        ThousandMultipleOrElseThrow(moneyAmount);

        return moneyAmount;
    }

    public List<Integer> mark() {
        String markedNumberString = clientInput.get();

        validateIsSplittedByComma(markedNumberString);

        List<Integer> numbers = parseStringToIntegerListOrElseThrow(markedNumberString);

        return numbers;
    }

    public Integer bonusMark() {
        String markedBonusNumberString = clientInput.get();

        int bonus;

        try {
             bonus = Integer.parseInt(markedBonusNumberString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_INTEGER);
        }

        if (bonus < 1 || bonus > 45 ) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_IN_RANGE);
        }

        return bonus;
    }

    private void validateIsSplittedByComma(String target) {
        for (int i = 1; i < target.length(); i += 2) {
            if (target.charAt(i) != ',') {
                throw new IllegalArgumentException(ErrorMessage.NUMBERS_SHOULD_BE_SPLITTED_WITH_COMMA);
            }
        }
    }

    private List<Integer> parseStringToIntegerListOrElseThrow(String markedNumberString) {
        try {
            return List.of(
                    Arrays.stream(markedNumberString.split(","))
                            .map(number -> Integer.parseInt(number))
                            .toArray(Integer[]::new));
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_NOT_INTEGERS);
        }
    }


    private int parseStringToIntOrElseThrow(String moneyAmountString) {
        int moneyAmount;
        try {
            moneyAmount = Integer.parseInt(moneyAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_INTEGER);
        }
        return moneyAmount;
    }

    private void ThousandMultipleOrElseThrow(int moneyAmount) {
        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_THOUSANDS_MULTIPLE);
        }
    }
}
