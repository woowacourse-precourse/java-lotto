package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String DEFAULT_ERROR_MESSAGE = "[ERROR]";
    public InputHandler() {
    }

    public static List<Integer> getWinningNumber() {
        String userInput = Console.readLine();
        List<Integer> winningNumber = validateListType(userInput);
        validateSize(winningNumber);
        winningNumber.forEach(InputHandler::validateRange);
        validateUnique(winningNumber);
        return winningNumber;
    }

    public static int getPurchaseAmount() {
        String userInput = Console.readLine();
        int inputMoney = validateNumberType(userInput);
        return validatePurchaseAmount(inputMoney);
    }

    public static int getBonusNumber() {
        String userInput = Console.readLine();
        int bonusNumber = validateNumberType(userInput);
        validateRange(bonusNumber);
        return bonusNumber;
    }

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.getLotto().contains(bonusNumber))
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.BONUS_NUMBER_DUPLICATED.getMessage());
    }

    private static List<Integer> validateListType(String userInput) {
        List<Integer> validatedNumbers;
        validatedNumbers = Arrays.stream(userInput.split(",")).map(InputHandler::validateNumberType).collect(Collectors.toList());
        return validatedNumbers;
    }

    private static void validateSize(List<Integer> userInput) {
        if (userInput.size() != CONSTANTS.LOTTO_COUNT.getNumbers()) {
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number > CONSTANTS.MAXIMUM.getNumbers() || number < CONSTANTS.MINIMUM.getNumbers()) {
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private static void validateUnique(List<Integer> userInput) {
        HashSet<Integer> numbers = new HashSet<>();
        for (Integer number :
                userInput) {
            if (!numbers.add(number)) {
                throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.NUMBER_DUPLICATED.getMessage());
            }
        }
    }

    private static int validateNumberType(String number) {
        try {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException E){
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.NUMBER_TYPE_EXCEPTION.getMessage());
        }
    }

    private static int validatePurchaseAmount(int money) {
        if (money % CONSTANTS.MONETARY_UNIT.getNumbers() != 0)
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + ERROR_MESSAGE.PURCHASE_UNIT_ERROR.getMessage());
        return money / CONSTANTS.MONETARY_UNIT.getNumbers();
    }
}
