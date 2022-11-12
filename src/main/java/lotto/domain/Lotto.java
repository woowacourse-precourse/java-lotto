package lotto.domain;

import java.util.List;

import static lotto.view.InputValidator.validateDifferentLottoNumbers;
import static lotto.view.InputValidator.validateRangeLottoNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDifferentLottoNumbers(numbers);
        validateRangeLottoNumbers(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> get(){
        return numbers;
    }

    private LottoResult lottoResult = LottoResult.LOSING;

    public void setLottoResult(LottoResult lottoResult){
        this.lottoResult = lottoResult;
    }

    public LottoResult getLottoResult(){
        return this.lottoResult;
    }

}
