package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import lotto.Constants;

public class LottoMachine {

    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER_RANGE.getValue(),
                Constants.MAX_LOTTO_NUMBER_RANGE.getValue(), Constants.LOTTO_NUMBERS_LENGTH.getValue());

        List<Integer> lottoNumbers = sortLottoNumbers(numbers);
        validateLottoNumber(lottoNumbers);

        return lottoNumbers;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        ArrayList<Integer> lottoNumbersCopy = new ArrayList<>(List.copyOf(numbers));
        lottoNumbersCopy.sort(Comparator.naturalOrder());
        return lottoNumbersCopy;
    }

    public void validateLottoNumber(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumbersDuplicated(numbers);
        validateLottoNumbersSorted(numbers);
        validateLottoNumbersInRange(numbers);
    }

    private void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException("6개의 숫자가 아닙니다.");
        }
    }

    private void validateLottoNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbersSet.size() != Constants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    private void validateLottoNumbersSorted(List<Integer> numbers) {
        for (int i = 0; i < Constants.LOTTO_NUMBERS_LENGTH.getValue() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException("숫자가 정렬되어 있지 않습니다.");
            }
        }
    }

    private void validateLottoNumbersInRange(List<Integer> numbers) {
        boolean rangeOverFlag = numbers.stream().anyMatch(number -> number < Constants.MIN_LOTTO_NUMBER_RANGE.getValue()
                || number > Constants.MAX_LOTTO_NUMBER_RANGE.getValue());

        if (rangeOverFlag) {
            throw new IllegalArgumentException("로또 숫자중 범위 밖의 숫자가 있습니다.");
        }
    }



}
