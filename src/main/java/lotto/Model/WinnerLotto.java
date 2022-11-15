package lotto.Model;

import lotto.DB.LottoData;

import java.util.List;

public class WinnerLotto {
    LottoData lottoData = new LottoData();
    public void setWinnerNumber(List<Integer> winnerNumber){
        Lotto winnerNumberLotto = new Lotto(winnerNumber);
        lottoData.setWinnerNumber(winnerNumberLotto);
    }

    public void setBonusNumber(int bonusNumber){
        lottoData.setBonusNumber(bonusNumber);
    }
}
