package models;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lotto = new Lotto(lottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    void validateBonusNumber(int bonusNumber) {
        validateInRange(bonusNumber);
        validateDuplication(bonusNumber);
    }

    private void validateInRange(int bonusNumber){
        if (IsCollection.isNumberInRange(bonusNumber, LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
    }
    private void validateDuplication(int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
