package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import lotto.constants.LottoConstants;
import lotto.constants.LottoExceptionConstants;

public class LottoMachine {

    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER_RANGE.getValue(),
                LottoConstants.MAX_LOTTO_NUMBER_RANGE.getValue(), LottoConstants.LOTTO_NUMBERS_LENGTH.getValue());

        List<Integer> lottoNumbers = sortLottoNumbers(numbers);
        validateLottoNumber(lottoNumbers);

        return lottoNumbers;
    }

    public List<Lotto> makeLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(generateLottoNumber()));
        }

        return lottos;
    }

    public void validateLottoNumber(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumbersDuplicated(numbers);
        validateLottoNumbersSorted(numbers);
        validateLottoNumbersInRange(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        ArrayList<Integer> lottoNumbersCopy = new ArrayList<>(List.copyOf(numbers));
        lottoNumbersCopy.sort(Comparator.naturalOrder());
        return lottoNumbersCopy;
    }

    private void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_LENGTH.getValue());
        }
    }

    private void validateLottoNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbersSet.size() != LottoConstants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }

    private void validateLottoNumbersSorted(List<Integer> numbers) {
        for (int i = 0; i < LottoConstants.LOTTO_NUMBERS_LENGTH.getValue() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_SORT.getValue());
            }
        }
    }

    private void validateLottoNumbersInRange(List<Integer> numbers) {
        boolean rangeOverFlag = numbers.stream().anyMatch(number -> number < LottoConstants.MIN_LOTTO_NUMBER_RANGE.getValue()
                || number > LottoConstants.MAX_LOTTO_NUMBER_RANGE.getValue());

        if (rangeOverFlag) {
            throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_RANGE.getValue());
        }
    }



}
