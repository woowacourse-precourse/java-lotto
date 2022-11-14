package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {

    public static final int LOTTO_LENGTH = 6;
    private static final String ERROR_MATCH_LENGTH = "로또는 6개의 번호만 입력 가능합니다.";
    private static final String ERROR_DUPLICATE_VALUE = "로또에는 중복된 번호를 입력할 수 없습니다.";
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = generateLottoNumber(numbers);
        validateNumbersLength(lottoNumbers);
        validateDuplicateValue(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<LottoNumber> generateLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::getInstance)
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumbersLength(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ERROR_MATCH_LENGTH);
        }
    }

    private void validateDuplicateValue(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> list = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (!list.isEmpty() && list.contains(lottoNumber)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_VALUE);
            }
            list.add(lottoNumber);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return new LottoIterator();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private class LottoIterator implements Iterator<LottoNumber> {

        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor != LOTTO_LENGTH;
        }

        @Override
        public LottoNumber next() {
            int index = cursor;
            cursor++;
            return numbers.get(index);
        }
    }
}
