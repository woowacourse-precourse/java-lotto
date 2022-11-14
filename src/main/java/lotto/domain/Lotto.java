package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 로또는 6자리의 숫자로 입력되야 합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또는 중복되지 않은 숫자로 이루어져야 합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = makeLottoNumbersBy(numbers);
    }

    public static int getLottoSize() {
        return LOTTO_SIZE;
    }

    public List<Integer> getNumbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            result.add(lottoNumber.getValue());
        }
        return result;
    }

    private List<LottoNumber> makeLottoNumbersBy(List<Integer> rawData) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer data : rawData) {
            lottoNumbers.add(makeIntToLottoNumber(data));
        }
        return lottoNumbers;
    }

    private LottoNumber makeIntToLottoNumber(Integer intData) {
        return new LottoNumber(intData);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }
}
