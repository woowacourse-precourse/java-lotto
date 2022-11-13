package lotto.application.service.inputvalidator;

import java.util.List;
import java.util.Stack;

public class InputValidatorImpl implements InputValidator {

    private static final InputValidator INPUT_VALIDATOR = new InputValidatorImpl();

    private InputValidatorImpl() {
    }

    public static InputValidator getInputValidator() {
        return INPUT_VALIDATOR;
    }

    @Override
    public void validatePurchaseMoneyInteger(String lottoPurchaseMoney) {
        try {
            Integer.parseInt(lottoPurchaseMoney);
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 구매 금액은 정수형으로, 입력 범위는 최대 2,147,483,647 까지 입니다.");
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수형으로, 입력 범위는 최대 2,147,483,647 까지 입니다.");
        }
    }

    @Override
    public void validatePurchaseMoneyDividable(String lottoPurchaseMoney) {
        if (Integer.parseInt(lottoPurchaseMoney) % 1000 != 0 || Integer.parseInt(lottoPurchaseMoney) == 0) {
            System.out.println("[ERROR] 구매 금액은 1000으로 나누어 떨어지는 단위만 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000으로 나누어 떨어지는 단위만 가능합니다.");
        }
    }

    @Override
    public void validateIntegerValue(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 보너스 로또 번호는 단 하나의 정수형을 입력하셔야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 단 하나의 정수형을 입력하셔야 합니다.");
        }
    }

    @Override
    public void validateIntegerValue(String[] inputValue) {
        try {
            for (String value : inputValue) {
                Integer.parseInt(value);
            }
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 로또 번호는 \"1,2,3,...\" 으로 입력받는 정수형이여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 \"1,2,3,...\" 으로 입력받는 정수형이여야 합니다.");
        }
    }

    @Override
    public void validateLottoNumbersOverlap(List<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int numberIndex = 0; numberIndex < numbers.size() - 1; numberIndex++) {
            stack.push(numbers.get(numberIndex));
            if (stack.contains(numbers.get(numberIndex + 1))) {
                System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    @Override
    public void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 보너스 숫자를 포함하지 않은 로또 번호 갯수는 6개입니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 숫자를 포함하지 않은 로또 번호 갯수는 6개입니다.");
        }
    }

    @Override
    public void winningNumbersAreNumeric(String winningNumbers) {
        if (!winningNumbers.chars().allMatch(Character::isDigit)) {
            System.out.println("[ERROR] 로또 당첨 번호는 \",\"를 구분자로 하는 6개의 정수만을 허용합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 \",\"를 구분자로 하는 6개의 정수만을 허용합니다.");
        }
    }

    @Override
    public void validateLottoNumbersRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public void validateBonusNumberOverlap(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 중복된 보너스 번호입니다.");
            throw new IllegalArgumentException("[ERROR] 중복된 보너스 번호입니다.");
        }
    }

    @Override
    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    @Override
    public void validateLottoPurchaseMoney(String lottoPurchaseMoney) {
        validatePurchaseMoneyInteger(lottoPurchaseMoney);
        validatePurchaseMoneyDividable(lottoPurchaseMoney);
    }

    @Override
    public void validateInputLottoNumber(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumbersOverlap(numbers);
        for (Integer number : numbers) {
            validateIntegerValue(String.valueOf(number));
            validateLottoNumbersRange(number);
        }
    }

    @Override
    public void validateInputBonusLottoNumber(String bonusNumber, List<Integer> numbers) {
        validateIntegerValue(bonusNumber);
        validateBonusNumberRange(Integer.parseInt(bonusNumber));
        validateBonusNumberOverlap(numbers, Integer.parseInt(bonusNumber));
    }

}
