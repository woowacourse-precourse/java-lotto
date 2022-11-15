package lotto.application.util.inputvalidator;

import java.util.List;
import java.util.Stack;

import static lotto.application.util.inputvalidator.ErrorMessage.*;

public class InputValidatorImpl implements InputValidator {

    private static final InputValidator INPUT_VALIDATOR = new InputValidatorImpl();

    private InputValidatorImpl() {
    }

    public static InputValidator getInputValidatorInstance() {
        return INPUT_VALIDATOR;
    }

    @Override
    public void validatePurchaseMoneyIsInteger(String lottoPurchaseMoney) {
        try {
            Integer.parseInt(lottoPurchaseMoney);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(PURCHASE_MONEY_IS_INTEGER.getErrorMessage());
        }
    }

    @Override
    public void validatePurchaseMoneyDividable(String lottoPurchaseMoney) {
        if (Integer.parseInt(lottoPurchaseMoney) % 1000 != 0 || Integer.parseInt(lottoPurchaseMoney) == 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_DIVIDABLE.getErrorMessage());
        }
    }

    @Override
    public void validateWinningNumbersAreInteger(String[] inputValue) {
        try {
            for (String value : inputValue) {
                Integer.parseInt(value);
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ARE_INTEGER.getErrorMessage());
        }
    }

    @Override
    public void validateWinningNumbersAreOverlapped(List<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int numberIndex = 0; numberIndex < numbers.size() - 1; numberIndex++) {
            stack.push(numbers.get(numberIndex));
            if (stack.contains(numbers.get(numberIndex + 1))) {
                throw new IllegalArgumentException(WINNING_NUMBERS_ARE_OVERLAPPED.getErrorMessage());
            }
        }
    }

    @Override
    public void validateWinningNumbersLengthIsSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_LENGTH_IS_SIX.getErrorMessage());
        }
    }

    @Override
    public void winningNumbersAreNumeric(String winningNumbers) {
        if (!winningNumbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_ARE_NUMERIC.getErrorMessage());
        }
    }

    @Override
    public void validateWinningNumbersRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE.getErrorMessage());
        }
    }

    @Override
    public void validateBonusNumberIsInteger(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_INTEGER.getErrorMessage());
        }
    }

    @Override
    public void validateBonusNumberIsOverlapped(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_OVERLAPPED.getErrorMessage());
        }
    }

    @Override
    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE.getErrorMessage());
        }
    }

    @Override
    public void validateLottoPurchaseMoney(String lottoPurchaseMoney) {
        validatePurchaseMoneyIsInteger(lottoPurchaseMoney);
        validatePurchaseMoneyDividable(lottoPurchaseMoney);
    }

    @Override
    public void validateInputLottoNumbers(List<Integer> numbers) {
        validateWinningNumbersLengthIsSix(numbers);
        validateWinningNumbersAreOverlapped(numbers);
        for (Integer number : numbers) {
            validateBonusNumberIsInteger(String.valueOf(number));
            validateWinningNumbersRange(number);
        }
    }

    @Override
    public void validateInputBonusLottoNumber(String bonusNumber, List<Integer> numbers) {
        validateBonusNumberIsInteger(bonusNumber);
        validateBonusNumberRange(Integer.parseInt(bonusNumber));
        validateBonusNumberIsOverlapped(numbers, Integer.parseInt(bonusNumber));
    }

}
