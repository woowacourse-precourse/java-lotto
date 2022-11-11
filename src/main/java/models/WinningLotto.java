package models;

import constants.LottoConstant;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber){
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
