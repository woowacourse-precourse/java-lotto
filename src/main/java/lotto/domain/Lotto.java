package lotto.domain;

import java.util.List;

public class Lotto {
    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    private final List<Integer> numbers;

    public static void setWinningNumbers(List<Integer> winningNumbers) {
        Lotto.winningNumbers = winningNumbers;
    }

    public static void setBonusNumber(int bonusNumber) {
        Lotto.bonusNumber = bonusNumber;
    }

    public static List<Integer> getWinningNumbers() {
        return Lotto.winningNumbers;
    }

    public static int getBonusNumber() {
        return Lotto.bonusNumber;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.lottoFormat(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
