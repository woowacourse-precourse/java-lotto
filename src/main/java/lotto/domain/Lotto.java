package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static List<Integer> winningNumbers;
    private static int bonusNumber;
    public static final int PRICE = 1000;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자를 필요로 합니다.");
        }
        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
