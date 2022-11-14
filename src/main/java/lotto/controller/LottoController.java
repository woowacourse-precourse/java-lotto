package lotto.controller;

import lotto.Enum.Ranking;
import lotto.domain.LottoAnswer;
import lotto.domain.User;
import lotto.service.CalProfitPercent;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.WinningCheck;

import java.util.List;
import java.util.Map;

public class LottoController {
    User user;
    LottoAnswer lottoAnswer;
    public void run() {
        OutputView.outputEnterMoney();
        user = new User(InputView.convertToNumber());
        OutputView.outputPurchaseSuccess(user.getUserLottos());
        OutputView.outputEnterLottoAnswer();
        List<Integer> numbers = InputView.convertToList();
        OutputView.outputEnterBonusNumber();
        lottoAnswer = new LottoAnswer(numbers, InputView.convertToNumber());
        WinningCheck winningCheck = new WinningCheck();
        CalProfitPercent calProfitPercent = new CalProfitPercent();
        Map<Ranking, Integer> winningResults =  winningCheck.winningCheck(
                user.getUserLottos(), lottoAnswer.getNumbers(), lottoAnswer.getBonusNumber());
        OutputView.outputWinningResults(winningResults, calProfitPercent.calProfitPercent(winningResults, user.getMoney()));
    }
}
