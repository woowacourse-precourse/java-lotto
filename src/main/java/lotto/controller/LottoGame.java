package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.*;

import java.util.List;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();
    public void run() {
        WinLottoResult winLottoResult = new WinLottoResult();
        try {
            UserMoney userMoney = inputMoney.inputUserMoney();
            countLottos(userMoney);
            pickRandomLottos(InputMoney.lottoPapers);
            List<Integer> winningLottoNumbers = inputLottoNumbers();
            winLottosResult(winningLottoNumbers, PickRandomLottoLists.randomLottoLists);
            winLottoResult.calculateYield(WinLottoResult.yield, userMoney);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void countLottos(UserMoney userMoney) {
        inputMoney.calculateLottoPapers(userMoney);
    }

    private void pickRandomLottos(int lottoPapers) {
        PickRandomLottoLists pickRandomLotto = new PickRandomLottoLists();

        pickRandomLotto.pickRandomLottoNumbers(lottoPapers);
    }

    private List<Integer> inputLottoNumbers() {
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> sixWinningNumbers = inputWinningNumbers.inputWinningNumber();
        sixWinningNumbers.add(inputBonusNumber.inputBonusNumber(sixWinningNumbers));
        return sixWinningNumbers;
    }

    private void winLottosResult(List<Integer> winningNumbers, List<List<Integer>> randomLottoLists) {
        WinLottoResult winLottoResult = new WinLottoResult();
        winLottoResult.checkWinLottoResult(winningNumbers, randomLottoLists);
    }
}