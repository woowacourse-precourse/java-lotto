package lotto;

import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_IS_NOT_6 = "[ERROR] 로또 번호 개수가 6이 아닙니다.";
    private static final String IS_DUPLICATED_LOTTO_NUMBER = "중복되는 로또 번호가 있습니다.";
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateLottoValue(numbers);
        this.numbers = numbers;
    }

    private void validateLottoValue(List<LottoNumber> numbers) {
        validateLottoSize(numbers);
        validateIsNotDuplicatedNumberInLotto(numbers);
    }

    private void validateIsNotDuplicatedNumberInLotto(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_IS_NOT_6);
        }
    }

    private void validateLottoSize(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = Sets.newHashSet(numbers);
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
