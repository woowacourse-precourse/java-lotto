package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.User;
import lotto.view.LottoCompareUI;

public class LottoCompare {
    private final LottoCompareUI lottoCompareUI = new LottoCompareUI();

    public void winningNumberCompareControl(User user){
        String winningNumber = lottoCompareUI.takeWinningNumber();
        LottoResult lottoResult = new LottoResult(winningNumber);
        String bonusNumber = lottoCompareUI.takeBonusNumber();
        lottoResult.setBonusNumber(bonusNumber);
    }
}
