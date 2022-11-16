package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.dto.LottoNumbersDTO;
import lotto.util.Validation;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers.forEach(Validation::validateLottoNumber);
        Validation.validateLottoNumberSize(numbers);
        Validation.validateDuplicates(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumber() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(int lottoNumber) {
        return getLottoNumber().contains(lottoNumber);
    }

    public int countMatchedNumbers(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public LottoNumbersDTO export() {
        return new LottoNumbersDTO(numbers);
    }
}
