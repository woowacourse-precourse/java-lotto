package lotto.domain;

import java.util.List;

import static lotto.domain.messages.ErrorMessages.DUPLICATE_BONUS_ERROR_MESSAGE;

public class WinningNumbersImple implements WinningNumbers{
    private Lotto winningLottoNumbers;
    private LottoNumber bonus;

    public WinningNumbersImple() {
    }

    private WinningNumbersImple(List<Integer> mainNumbers, Integer bonus) {
        this.winningLottoNumbers = Lotto.generateFromRawValues(mainNumbers);
        this.bonus = LottoNumber.generateFromRawValue(bonus);
        validate(); //반드시 필드 값 할당 후에 실행해야 함
    }

    @Override
    public WinningNumbersImple generateFromRawValues(List<Integer> mainNumbers
            , Integer bonus) {

        WinningNumbersImple createdWinningNumbers = new WinningNumbersImple(mainNumbers
                , bonus);

        return createdWinningNumbers;
    }

    private void validate() {
        validateDuplicateWithBonus();
    }

    private void validateDuplicateWithBonus() {
        if (this.winningLottoNumbers.isMatchedNumbersWith(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isBonusMatchedIn(Lotto lotto) {
        return lotto.isMatchedNumbersWith(bonus);
    }

    @Override
    public int countWinningLottoNumbersMatchedIn(Lotto lotto) {
        return lotto.countMatchedNumbersWith(winningLottoNumbers);
    }

}
