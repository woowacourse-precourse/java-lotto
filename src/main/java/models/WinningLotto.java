package models;

import models.validation.WinningLottoValidation;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        lotto = new Lotto(lottoNumbers);
        WinningLottoValidation.validateBonusNumber(lotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
