package lotto.domain;

import static lotto.domain.LottoConstant.*;

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
        if (numbers.size() != LOTTO_SIZE) {
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
        if (Collections.min(numbers) < LOTTO_MIN_RANGE || Collections.max(numbers) > LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d ~ %d 사이의 숫자만 입력가능합니다.", LOTTO_MIN_RANGE,
                    LOTTO_MAX_RANGE));
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public static Lotto generateLottoAuto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_SIZE);
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
