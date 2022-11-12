package lotto.domain;

public class InputValidator {

    private static int LOTTERY_MINIMUM_NUMBER = 1;
    private static int LOTTERY_MAXIMUM_NUMBER = 45;
    private static int COUNT_OF_LOTTERY_NUMBERS = 6;

    public void validateInputMoney(String inputMoney) {
        if (includeNotNumericCharacter(inputMoney)) {
            System.out.println(ErrorMessage.MONEY_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        int userMoney = Integer.parseInt(inputMoney);
        if (!isMultipleOfOneThousand(userMoney)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean includeNotNumericCharacter(String userInput) {
        for (int i = 0; i < userInput.length(); ++i) {
            if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9') {
                return true;
            }
        }
        return false;
    }

    private boolean isMultipleOfOneThousand(int userMoney) {
        if (userMoney % 1000 == 0) {
            return true;
        }
        return false;
    }

    public void validateWinningNumbers(String winningNumbersInput) {
        String[] winningNumbers = winningNumbersInput.split(",");
        if (!isCorrectCountOfNumbers(winningNumbers)) {
            System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < winningNumbers.length; ++i) {
            if (includeNotNumericCharacter(winningNumbers[i])) {
                System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }

            int number = Integer.parseInt(winningNumbers[i]);
            if (isNumberOutOfRange(number)) {
                System.out.println(ErrorMessage.DRAW_NUMBER_INPUT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isCorrectCountOfNumbers(String[] winningNumbersInput) {
        return winningNumbersInput.length == COUNT_OF_LOTTERY_NUMBERS;
    }

    private boolean isNumberOutOfRange(int number) {
        return number < LOTTERY_MINIMUM_NUMBER || number > LOTTERY_MAXIMUM_NUMBER;
    }
}
