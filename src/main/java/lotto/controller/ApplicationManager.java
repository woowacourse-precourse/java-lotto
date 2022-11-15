package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Referee;

import java.util.List;
import java.util.Map;

public class ApplicationManager {
    public void run() {
        Map<Integer, Integer> result;
        List<Lotto> userLottos;
        List<Integer> winningNumber;

        LottoManager lottoManager = new LottoManager();

        int userMoney = lottoManager.getMoney();
        int numberLottos = lottoManager.getNumberLottos(userMoney);

        lottoManager.printPublishedLottos(numberLottos);

        userLottos = lottoManager.publishLottoForPrice(numberLottos);

        winningNumber = lottoManager.GenerateLottoNumbers();
        int bonusNumber = lottoManager.GenerateBonusNumber();

        result = Referee.compare(bonusNumber, winningNumber, userLottos);

        lottoManager.printWinningMessage(result);

        lottoManager.printProfit(userMoney, result);
    }
}
