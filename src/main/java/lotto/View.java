package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class View {
    private void validateIsDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000으로 나눠떨어져야 합니다");
        }
    }
    private void validateIsNumber(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다");
        }
    }
    private void validateAreNumbers(String input) {
        String[] splitInput = input.split(",");
        for (String value : splitInput) {
            validateIsNumber(value);
        }
    }
    private void validateUniqueNumbersInput(List<Integer> numbers) {
        List<Integer> noDuplicates = new ArrayList<>();
        for (int num : numbers) {
            if (noDuplicates.contains(num)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자만 입력이 가능합니다");
            }
            noDuplicates.add(num);
        }
    }
    private void validateNumbersInRange(List<Integer> numbers) {
        for (int num : numbers) {
            if ((45 < num) || num < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다");
            }
        }
    }
    private void validateNumberOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 총 6개를 입력해야 합니다");
        }
    }
    private void validateUniqueBonusNumberInput(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자만 입력이 가능합니다");
        }
    }
    public int getMoneyInput() {
        String moneyString = Console.readLine();
        int money;
        validateIsNumber(moneyString);
        money = Integer.parseInt(moneyString);
        validateIsDivisible(money);
        return money;
    }
    public List<Integer> getUniqueNumbersInput() {
        String numbersString = Console.readLine();
        String[] numbersSplit;
        List<Integer> numbersInteger= new ArrayList<>();
        validateAreNumbers(numbersString);
        numbersSplit = numbersString.split(",");
        for (String num : numbersSplit) {
            numbersInteger.add(Integer.parseInt(num));
        }
        validateNumbersInRange(numbersInteger);
        validateNumberOfNumbers(numbersInteger);
        validateUniqueNumbersInput(numbersInteger);
        return numbersInteger;
    }

}

