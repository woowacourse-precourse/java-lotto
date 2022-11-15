package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.User;
import lotto.view.WinningNumberCompareUI;

public class WinningNumberCompare {
    private final WinningNumberCompareUI winningNumberCompareUI = new WinningNumberCompareUI();

    public void winningNumberCompareControl(User user){
        String winningNumber = winningNumberCompareUI.takeWinningNumber();
        LottoResult lottoResult = new LottoResult(winningNumber);
        String bonusNumber = winningNumberCompareUI.takeBonusNumber();
        lottoResult.setBonusNumber(bonusNumber);
    }
}
