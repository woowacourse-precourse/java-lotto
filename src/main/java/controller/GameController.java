package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoHandler;
import type.LottoGrade;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {

    public void playLottoGame() {
        InputView.printAtStart();
        String inputAmount = Console.readLine();
        Integer purchaseAmount = Integer.valueOf(inputAmount);
        List<Lotto> lottos = LottoHandler.getLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);
        InputView.printAfterLottoNumbers();
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = LottoHandler.getWinningNumbers(inputNumbers);
        InputView.printAfterWinningNumbers();
        String bonusNumber = Console.readLine();
        Map<LottoGrade, Integer> resultOfLotto = LottoHandler.getResultOfLotto(bonusNumber, winningNumbers, lottos);
        Double rateOfReturn = LottoHandler.getRateOfReturn(resultOfLotto, purchaseAmount);
        OutputView.printResultOfLotto(resultOfLotto, rateOfReturn);
    }
}
