package lotto.domain;

import static lotto.util.Constants.NUMBER_COUNTS;
import static lotto.util.Formatter.verifyRangeOfLottoNumber;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNTS) {
            throw new IllegalArgumentException("6개의 당첨번호를 입력해 주세요.");
        }
        validateRangeOfNumbers(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("입력하신 당첨번호 내에 중복되는 숫자가 존재합니다.");
        }
    }

    private static void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer winningNumber : numbers) {
            verifyRangeOfLottoNumber(winningNumber);
        }
    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

}
