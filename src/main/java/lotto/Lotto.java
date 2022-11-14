package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.ui.Validator;
import java.util.Collections;

public class Lotto {
    private final List<LottoNumber> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);
        List<LottoNumber> lottoNumbers = this.convertIntegersToNumbers(numbers);
        this.sort(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<LottoNumber> convertIntegersToNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public List<Integer> getNumbersAsIntegers() {
        return this.numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.throwIfNotSix(numbers);
        validator.throwIfNotUnique(numbers);
    }

    private void sort(List<LottoNumber> numbers) {
        Collections.sort(numbers);
    }

    private LottoNumber getLottoNumberAt(int index) {
        return this.numbers.get(index);
    }

    public void checkBonusNumber(LottoNumber bonusNumber) {
        Validator validator = new Validator();
        List<Integer> integerNumbers = this.convertNumbersToIntegers();
        validator.throwIfAlreadyHasNumber(integerNumbers, bonusNumber);
    }

    private List<Integer> convertNumbersToIntegers() {
        return this.numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
    }

    public boolean contains(LottoNumber lottoNumber) {
        List<Integer> integerNumbers = this.convertNumbersToIntegers();
        return integerNumbers.contains(lottoNumber.getNumber());
    }

    public int getMatchCount(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        int matchCount = 0;
        for (int i = 0; i < Constants.LOTTO_NUMBER_COUNT.getNumber(); i++) {
            if (this.contains(winningLotto.getLottoNumberAt(i))) {
                matchCount += 1;
            }
        }
        if (matchCount == Constants.LOTTO_NUMBER_COUNT.getNumber() - 1) {
            if (this.contains(bonusLottoNumber)) {
                matchCount += 2;
            }
        }
        return matchCount;
    }

    public String toString() {
        return Arrays.toString(this.numbers.stream().map(LottoNumber::getNumber).toArray());
    }
}
