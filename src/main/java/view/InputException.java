package view;

import util.ExceptionPharse;
import util.GameStatus;
import util.LottoStatus;
import util.MoneyStatus;

public class InputException {
    public static void nullException(String userInput) throws IllegalArgumentException {
        if (userInput == null || userInput.isBlank() || userInput.isEmpty()) {
            throw new IllegalArgumentException(ExceptionPharse.IS_NULL.getExceptionMsg());
        }
    }

    public static void notNumberException(String userInput) throws IllegalArgumentException {
        for (int eachIndex = 0; eachIndex < userInput.length(); eachIndex++) {
            eachInputNotNumber(userInput.charAt(eachIndex));
        }
    }

    private static void eachInputNotNumber(char eachInput) throws IllegalArgumentException {
        if (!Character.isDigit(eachInput)) {
            throw new IllegalArgumentException(ExceptionPharse.IS_NOT_NUMBER.getExceptionMsg());
        }
    }

    public static void notDividedThousandException(int userInput) throws IllegalArgumentException {
        if (!isDivided(userInput)) {
            throw new IllegalArgumentException(ExceptionPharse.IS_NOT_DIVIDED.getExceptionMsg());
        }
    }

    private static boolean isDivided(int userInput) {
        return userInput % MoneyStatus.MONEY_DIVIDE.getStatus() == 0;
    }

    public static void notLottoSize(int size) {
        if (size != LottoStatus.LOTTO_SIZE.getCode()) {
            throw new IllegalArgumentException(ExceptionPharse.OUT_OF_LOTTO_SIZE.getExceptionMsg());
        }
    }

    public static void notFormat(String userInput) {
        if (userInput.endsWith(GameStatus.COMMA.getCode())) {
            throw new IllegalArgumentException(ExceptionPharse.IS_NOT_FORMAT.getExceptionMsg());
        }
    }
}
