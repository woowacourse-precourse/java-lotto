package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
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

    // TODO: 추가 기능 구현
}
