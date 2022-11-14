package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String LOTTO_SIZE_IS_NOT_6 = "[ERROR] 로또 번호 개수가 6이 아닙니다.";
    private static final String IS_DUPLICATED_LOTTO_NUMBER = "[ERROR] 중복되는 로또 번호가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoValue(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE));
    }

    private void validateLottoValue(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateIsNotDuplicatedNumberInLotto(numbers);
    }

    private void validateIsNotDuplicatedNumberInLotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_IS_NOT_6);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        Set<Integer> lottoNumbers = Sets.newHashSet(numbers);
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
