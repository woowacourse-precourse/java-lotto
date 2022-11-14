package lotto;

import java.util.Arrays;
import java.util.List;

public class Client {

    private static final String MONEY_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 금액 입력은 숫자여야 합니다.";
    private static final String MONEY_NOT_THOUSANDS_ERROR_MESSAGE = "[ERROR] 금액 입력은 1,000의 배수여야 합니다.";
    private static final String COMMA_SPLIT_ERROR_MESSAGE = "[ERROR] 로또 입력 번호는 ,를 기준으로 구분되어야 합니다.";
    private static final String NUMBERS_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 로또 입력 번호는 숫자여야 합니다.";
    private static final String BONUS_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String BONUS_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1보다 크고 46보다 작은 숫자여야 합니다.";

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
            throw new IllegalArgumentException(BONUS_NOT_INTEGER_ERROR_MESSAGE);
        }

        if (bonus < 1 || bonus > 45 ) {
            throw new IllegalArgumentException(BONUS_NOT_IN_RANGE_ERROR_MESSAGE);
        }

        return bonus;
    }

    private void validateIsSplittedByComma(String target) {
        for (int i = 1; i < target.length(); i += 2) {
            if (target.charAt(i) != ',') {
                throw new IllegalArgumentException(COMMA_SPLIT_ERROR_MESSAGE);
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
            throw new IllegalArgumentException(NUMBERS_NOT_INTEGER_ERROR_MESSAGE);
        }
    }


    private int parseStringToIntOrElseThrow(String moneyAmountString) {
        int moneyAmount;
        try {
            moneyAmount = Integer.parseInt(moneyAmountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(MONEY_NOT_INTEGER_ERROR_MESSAGE);
        }
        return moneyAmount;
    }

    private void ThousandMultipleOrElseThrow(int moneyAmount) {
        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_NOT_THOUSANDS_ERROR_MESSAGE);
        }
    }
}
