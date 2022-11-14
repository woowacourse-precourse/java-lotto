package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.*;

import java.util.List;

import static lotto.service.PickRandomLotto.randomLottoLists;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();
    WinLottoResult winLottoResult = new WinLottoResult();

    public void run() {
        UserMoney userMoney = inputMoney.InputMoney();
        countLottoPapers(userMoney);
        pickRandomLottos(inputMoney.lottoCount);
        List<Integer> answerLotto = inputLottoNumbers();
        winLottosResult(answerLotto,randomLottoLists);
        winLottoResult.calBenefit(winLottoResult.profitMoney, userMoney);
    }

    public void countLottoPapers(UserMoney userMoney) {
        inputMoney.lottoCount(userMoney);
    }

    public void pickRandomLottos(int lottoPapers) {
        PickRandomLotto pickRandomLotto = new PickRandomLotto();

        pickRandomLotto.PickRandomNumber(lottoPapers);
    }

    public List<Integer> inputLottoNumbers() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> sixLottoNumbers = inputLottoNumber.inputSixNumbers();
        sixLottoNumbers.add(inputBonusNumber.inputBonusNumber(sixLottoNumbers));
        return sixLottoNumbers;
    }

    public void winLottosResult(List<Integer> answerLotto, List<List<Integer>> dataLotto) {
        WinLottoResult winLottoResult = new WinLottoResult();
        winLottoResult.checkWinLottoResult(answerLotto, dataLotto);
    }
}