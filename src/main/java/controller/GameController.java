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
        Integer purchaseAmount = getPurchaseAmount();
        List<Lotto> lottos = createLottos(purchaseAmount);
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber();
        getResultOfLotto(purchaseAmount, lottos, winningNumbers, bonusNumber);
    }

    private void getResultOfLotto(Integer purchaseAmount,
                                  List<Lotto> lottos,
                                  List<Integer> winningNumbers,
                                  Integer bonusNumber) {
        Map<LottoGrade, Integer> resultOfLotto = LottoHandler.getResultOfLotto(lottos, winningNumbers, bonusNumber);
        Double rateOfReturn = LottoHandler.getRateOfReturn(resultOfLotto, purchaseAmount);
        OutputView.printResultOfLotto(resultOfLotto, rateOfReturn);
    }

    private Integer getBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.valueOf(bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        String inputNumbers = Console.readLine();
        List<Integer> winningNumbers = LottoHandler.getWinningNumbers(inputNumbers);
        InputView.printAfterWinningNumbers();
        return winningNumbers;
    }

    private List<Lotto> createLottos(Integer purchaseAmount) {
        List<Lotto> lottos = LottoHandler.getLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);
        InputView.printAfterLottoNumbers();
        return lottos;
    }

    private Integer getPurchaseAmount() {
        InputView.printAtStart();
        String inputAmount = Console.readLine();
        Integer purchaseAmount = Integer.valueOf(inputAmount);
        return purchaseAmount;
    }
}
