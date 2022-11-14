package lotto.domain.entity;

import static lotto.common.message.ExceptionMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.vo.MatchReport;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        lottoNumberRangeCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                ERROR_CODE + LOTTO_NUMBERS_SIZE_OUT_OF_RANGE_MESSAGE);
        }
    }

    // TODO: 추가 기능 구현
    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
        if (numbers.size() != duplicatedNumbers.size()) {
            throw new IllegalArgumentException(ERROR_CODE + LOTTO_NUMBERS_DUPLICATE_MESSAGE);
        }
    }

    private void lottoNumberRangeCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_CODE + LOTTO_NUMBERS_OUT_OF_VALUE_MESSAGE);
            }
        }
    }

    public List<Integer> currentLottoNumbers() {
        return numbers;
    }

    public void printLottoNumbers() {
        System.out.println(numbers);
    }

    public MatchReport matchNumbers(Lotto lottoNumbers, int bonusNumber) {

        MatchReport matchReport = new MatchReport();
        List<Integer> givenLottoNumbers = lottoNumbers.currentLottoNumbers();

        if (numbers.contains(bonusNumber)) {
            matchReport.bonusTurnTrue();
        }

        for (Integer number : numbers) {
            hasNumber(matchReport, givenLottoNumbers, number);
        }
        return matchReport;
    }

    private void hasNumber(MatchReport matchReport, List<Integer> givenLottoNumbers,
        Integer number) {
        if (givenLottoNumbers.contains(number)) {
            matchReport.countPlus();
        }
    }
}
