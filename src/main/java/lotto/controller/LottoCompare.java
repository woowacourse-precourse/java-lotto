package lotto.controller;

import lotto.model.LottoWinner;
import lotto.model.User;
import lotto.view.LottoCompareUI;

public class LottoCompare {
    private final LottoCompareUI lottoCompareUI = new LottoCompareUI();

    public void winningNumberCompareControl(User user){
        String winningNumber = lottoCompareUI.takeWinningNumber();
        LottoWinner lottoWinner = new LottoWinner(winningNumber);
        String bonusNumber = lottoCompareUI.takeBonusNumber();
        lottoWinner.setBonusNumber(bonusNumber);
    }
}
