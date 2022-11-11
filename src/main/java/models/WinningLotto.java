package models;

import constants.LottoConstant;
import system.process.exception.IllegalArgument;

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
        if (bonusNumber < LottoConstant.NUMBER_START || bonusNumber > LottoConstant.NUMBER_END) {
            IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
