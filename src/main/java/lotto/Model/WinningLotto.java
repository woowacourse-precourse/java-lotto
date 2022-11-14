package lotto.Model;

import lotto.Service.LottoValidator;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        LottoValidator lottoValidator = new LottoValidator();
        
        lottoValidator.validate(numbers, bonusNumber);
    }
}
