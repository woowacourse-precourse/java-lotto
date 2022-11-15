package lotto;

import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자는 중복되지 않는 숫자 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또의 숫자는 1이상 45이하여야 합니다.");
            }
        }
        Set<Integer> comparedNumbers = new HashSet<>(numbers);
        if (comparedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자는 중복될 수 없습니다.");
        }
    }

    // 로또 한 개 발행
    public static Lotto publishLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
