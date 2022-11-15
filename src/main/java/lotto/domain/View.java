package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;



public class View {
    private final String ERROR_MESSAGE = "[ERROR]";
    public final String ERROR_INDIVISIBLE = ERROR_MESSAGE + " 로또 구입 금액은 1000으로 나눠떨어져야 합니다";
    public final String ERROR_INTEGERS = ERROR_MESSAGE + " 숫자만 입력이 가능합니다";
    public final String ERROR_UNIQUE = ERROR_MESSAGE + " 중복되지 않는 숫자만 입력이 가능합니다";
    public final String ERROR_RANGE = ERROR_MESSAGE +" 1부터 45 사이의 숫자여야 합니다";
    public final String ERROR_SIZE = ERROR_MESSAGE + " 당첨번호 총 6개를 입력해야 합니다";

    public static final int LOTTO_PRICE = 1000;
    public int validateIsDivisible(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INDIVISIBLE);
        }
        return money/LOTTO_PRICE;
    }
    public int validateIsNumber(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INTEGERS);
        }
        return money;
    }

    public List<Integer> validateAreNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String value : splitInput) {
            try {
                numbers.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_INTEGERS);
            }
        }
        return numbers;
    }
    public void validateUniqueNumbers(List<Integer> numbers) {
        List<Integer> noDuplicates = new ArrayList<>();
        for (int num : numbers) {
            validateUniqueNumber(noDuplicates, num);
            noDuplicates.add(num);
        }
    }
    public void validateUniqueNumber(List<Integer> noDuplicates, int num) {
        if (noDuplicates.contains(num)) {
            throw new IllegalArgumentException(ERROR_UNIQUE);
        }
    }
    public void validateNumbersInRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberInRange(num);
        }
    }
    public void validateNumberInRange(int num) {
        if ((45 < num) || num < 1) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }
    public void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    private List<Integer> validateWinnerInput(String input) {
        List<Integer> numbersInteger = validateAreNumbers(input);
        validateNumbersInRange(numbersInteger);
        validateNumberOfNumbers(numbersInteger);
        validateUniqueNumbers(numbersInteger);
        return numbersInteger;
    }
    private int validateBonusInput(String input, List<Integer> numbers) {
        validateIsNumber(input);
        int bonus = Integer.parseInt(input);
        validateNumberInRange(bonus);
        validateUniqueNumber(numbers, bonus);
        return bonus;
    }
    public List<Integer> getWinnerInput() {
        String numbersString = Console.readLine();
        return validateWinnerInput(numbersString);
    }
    public int getBonusInput(List<Integer> numbers) {
        String bonusString = Console.readLine();
        return validateBonusInput(bonusString, numbers);
    }

}

