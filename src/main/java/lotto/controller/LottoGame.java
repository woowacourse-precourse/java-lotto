package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.*;

import java.util.List;

import static lotto.service.PickRandomLottoLists.randomLottoLists;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();
    UserMoney userMoney = inputMoney.InputMoney();
    WinLottoResult winLottoResult = new WinLottoResult();

    public void run() {
        try {
            countLottos(userMoney);
            pickRandomLottos(inputMoney.lottoCount);
            List<Integer> randomLottoLists = inputLottoNumbers();
            winLottosResult(randomLottoLists, PickRandomLottoLists.randomLottoLists);
            winLottoResult.calBenefit(winLottoResult.profitMoney, userMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void countLottos(UserMoney userMoney) {
        inputMoney.calculateLottoPapers(userMoney);
    }

    public void pickRandomLottos(int lottoPapers) {
        PickRandomLottoLists pickRandomLotto = new PickRandomLottoLists();

        pickRandomLotto.PickRandomLottoNumbers(lottoPapers);
    }

    public List<Integer> inputLottoNumbers() {
        InputLottoNumbers inputLottoNumbers = new InputLottoNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> sixLottoNumbers = inputLottoNumbers.inputSixNumbers();
        sixLottoNumbers.add(inputBonusNumber.inputBonusNumber(sixLottoNumbers));
        return sixLottoNumbers;
    }

    public void winLottosResult(List<Integer> answerLotto, List<List<Integer>> dataLotto) {
        WinLottoResult winLottoResult = new WinLottoResult();
        winLottoResult.checkWinLottoResult(answerLotto, dataLotto);
    }
}