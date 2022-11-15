package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateLottoNumber(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리를 입력해야 합니다");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다");
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        if (Collections.min(numbers) < 1 || Collections.max(numbers) > 45) {
            throw new IllegalArgumentException("1 ~ 45 사이의 숫자만 입력가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto generateLottoAuto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public int containsCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
