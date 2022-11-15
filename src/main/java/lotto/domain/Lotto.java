package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.exception.IllegalArgumentError;
import lotto.util.Constants;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumbers(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public int countNumberOfMatchesWith(Lotto anotherLotto) {
        int count = 0;
        for (LottoNumber number : anotherLotto.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean have(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
    }

    private void validateUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != Constants.LENGTH_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentError("this lotto contains duplicated number");
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LENGTH_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentError("length of numbers is not suitable");
        }
    }

    // TODO: 추가 기능 구현
}
