package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class View {
    private int validateIsDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000으로 나눠떨어져야 합니다");
        }
        return money/1000;
    }
    private int validateIsNumber(String input) {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다");
        }
        return num;
    }
    private List<Integer> validateAreNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitInput = input.split(",");
        for (String value : splitInput) {
            numbers.add(validateIsNumber(value));
        }
        return numbers;
    }
    public void validateUniqueNumbersInput(List<Integer> numbers) {
        List<Integer> noDuplicates = new ArrayList<>();
        for (int num : numbers) {
            validateUniqueNumber(noDuplicates, num);
            noDuplicates.add(num);
        }
    }
    private void validateUniqueNumber(List<Integer> noDuplicates, int num) {
        if (noDuplicates.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자만 입력이 가능합니다");
        }
    }
    public void validateNumbersInRange(List<Integer> numbers) {
        for (int num : numbers) {
            validateNumberInRange(num);
        }
    }
    private void validateNumberInRange(int num) {
        if ((45 < num) || num < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }
    public void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 총 6개를 입력해야 합니다");
        }
    }
    private void validateUniqueNumberInput(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자만 입력이 가능합니다");
        }
    }
    private List<Integer> validateWinnerInput(String input) {
        List<Integer> numbersInteger = validateAreNumbers(input);
        validateNumbersInRange(numbersInteger);
        validateNumberOfNumbers(numbersInteger);
        validateUniqueNumbersInput(numbersInteger);
        return numbersInteger;
    }
    private int validateBonusInput(String input, List<Integer> numbers) {
        int bonus = validateIsNumber(input);
        validateNumberInRange(bonus);
        validateUniqueNumberInput(numbers, bonus);
        return bonus;
    }
    public int getMoneyInput() {
        String moneyString = Console.readLine();
        int money = validateIsNumber(moneyString);
        validateIsDivisible(money);
        return money;
    }
    public List<Integer> getWinnerInput() {
        String numbersString = Console.readLine();
        List<Integer> numbersInteger = validateWinnerInput(numbersString);
        return numbersInteger;
    }
    public int getBonusInput(List<Integer> numbers) {
        String bonusString = Console.readLine();
        int bonus = validateBonusInput(bonusString, numbers);
        return bonus;
    }

}

