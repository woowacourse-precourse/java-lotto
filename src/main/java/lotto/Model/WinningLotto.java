package lotto.Model;

import lotto.Service.LottoService;
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

    public int getWinningResult(Lotto lotto) {
        LottoService lottoService = new LottoService();

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = this.getNumbers();

        int count = lottoService.countWinning(lottoNumbers, winningNumbers);
        if (count == LottoResult.FIVE_WINS.getValue() && lottoNumbers.contains(bonusNumber)) {
            count = LottoResult.FIVE_AND_BONUS_WINS.getValue();
        }

        return count;
    }

}
