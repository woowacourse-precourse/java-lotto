package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import lotto.resource.message.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateLottoNumberCount(numbers);

        this.numbers = numbers;
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getValue());
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_COUNT.getValue());
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber.getValueAsInt());
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public int getMaxNum() {
        return numbers.stream().reduce(Math::max).orElse(-1);
    }

    public int getMinNum() {
        return numbers.stream().reduce(Math::min).orElse(-1);
    }

    public int getCount() {
        return numbers.size();
    }


}
