package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final static int TWO_LOTTERIES = 12;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 숫자의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getMatchCountWith(Lotto lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto.numbers);
        uniqueNumbers.addAll(this.numbers);

        return TWO_LOTTERIES - uniqueNumbers.size();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
