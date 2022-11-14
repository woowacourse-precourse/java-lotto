package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.Application.numberType;
import lotto.Application.NumberType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
        set(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        checkRange(numbers);
        hasSixNumbers(numbers);
        isDuplicated(numbers);
    }

    private static void hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 쉼표로 구분되는 6개의 수로 입력해 주세요.");
    }

    private static void checkRange(List<Integer> numbers) {
        for (int number : numbers)
            if (number > 45 || number < 1)
                throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    private static void isDuplicated(List<Integer> numbers) {
        boolean[] isWinningNumber = new boolean[46];
        for (int number : numbers) {
            if (isWinningNumber[number])
                throw new IllegalArgumentException("[ERROR] 당첨 번호엔 중복된 숫자가 없어야 합니다.");
            isWinningNumber[number] = true;
        }
    }

    private static void set(List<Integer> winningNumbers) {
        for (int number : winningNumbers)
            numberType[number] = NumberType.WINNING;
    }
}