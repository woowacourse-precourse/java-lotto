package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers() {
        numbers = initializeNumbers();
        bonus = initializeBonus();
    }

    private List<Integer> initializeNumbers() {
        System.out.println(Message.WINNING_NUMBERS_REQUEST);

        String numbersInput = Console.readLine();

        return validateNumbers(numbersInput);
    }

    private List<Integer> validateNumbers(String numbersInput) {
        List<Integer> numbers = validateNumbersIsCorrectInputForm(numbersInput);

        validateNumbersIsInRange(numbers);

        validateNumbersIsNotDuplicated(numbers);

        return numbers;
    }

    private List<Integer> validateNumbersIsCorrectInputForm(String numbersInput) {
        List<Integer> numbers = new ArrayList<>();

        try {
            Arrays.stream(numbersInput.split(",")).forEach(v -> numbers.add(Integer.parseInt(v)));

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자 6개를 쉼표(,)로 구분해야 합니다.");
        }
    }

    private void validateNumbersIsInRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(v -> v >= LottoGenerator.LOTTO_NUMBER_RANGE_START && v <= LottoGenerator.LOTTO_NUMBER_RANGE_END)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumbersIsNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
        }
    }

    private int initializeBonus() {
        System.out.println(Message.BONUS_NUMBER_REQUEST);

        String bonusInput = Console.readLine();

        return validateBonus(bonusInput);
    }


    private int validateBonus(String bonusInput) {
        try {
            int bonus = Integer.parseInt(bonusInput);

            if (bonus < LottoGenerator.LOTTO_NUMBER_RANGE_START || bonus > LottoGenerator.LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
            }

            if (numbers.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
            }

            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }
}
