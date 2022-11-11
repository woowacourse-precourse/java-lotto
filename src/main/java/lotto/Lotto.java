package lotto;

import java.util.List;
import java.util.function.Predicate;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Enum.ConstantNumber.*;
import static lotto.Enum.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    // 자동 로또 생성
    public Lotto() {
        this.numbers = makeLottoAuto();
    }

    // 수동 로또 생성
    public Lotto(List<Integer> numbers) {
        validateLottoNum(numbers);
        this.numbers = numbers;
    }

    private List<Integer> makeLottoAuto() {
        List<Integer> random_numbers = pickUniqueNumbersInRange(1, 45, 6);

        validateLottoNum(random_numbers);

        return random_numbers;
    }

    private void validateLottoNum(List<Integer> numbers) {
        validateLottoNumLength(numbers);
        validateLottoNumDuplicated(numbers);
        validateLottoNumRange(numbers);
    }

    private void validateLottoNumLength(List<Integer> numbers) {
        if (numbers.size() != SIX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_LENGTH_ERROR.getMessage());
        }
    }

    private void validateLottoNumDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != SIX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATED_ERROR.getMessage());
        }
    }

    private void validateLottoNumRange(List<Integer> numbers) {
        if (numbers.stream()
                .filter(this::checkLottoNumRange)
                .count() != SIX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_RANGE_ERROR.getMessage());
        }
    }

    public boolean checkLottoNumRange(int num) {
        return num > ZERO.getValue()
                && num <= FOURTY_FIVE.getValue();
    }
}
