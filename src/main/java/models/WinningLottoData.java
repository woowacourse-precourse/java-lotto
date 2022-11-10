package models;

import java.util.List;

public class WinningLottoData {

    private Lotto lotto;
    private int bonusNumber;

    public WinningLottoData(List<Integer> lottoNumbers,int bonusNumber){
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

}
