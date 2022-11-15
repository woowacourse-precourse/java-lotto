package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.LottoWinner;
import lotto.model.User;
import lotto.view.LottoCompareUI;

public class LottoCompare {
    private final LottoCompareUI lottoCompareUI = new LottoCompareUI();

    public LottoResult controlLottoCompare(User user){
        String winningNumber = lottoCompareUI.takeWinningNumber();
        LottoWinner lottoWinner = new LottoWinner(winningNumber);

        String bonusNumber = lottoCompareUI.takeBonusNumber();
        lottoWinner.setBonusNumber(bonusNumber);

        LottoResult lottoResult = new LottoResult();
        lottoResult.setResults(user.getUserLottos(), lottoWinner.getWinningNumbers(), lottoWinner.getBonusNumber());

        return lottoResult;
    }
}
