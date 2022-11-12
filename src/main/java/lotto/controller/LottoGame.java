package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.InputBonusNumber;
import lotto.service.InputLottoNumber;
import lotto.service.InputMoney;
import lotto.service.PickRandomLotto;

import java.util.List;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();

    public void run() {
        UserMoney userMoney = inputMoney.InputMoney();
        countLottoPapers(userMoney);
        pickRandomLottos(inputMoney.lottoCount);
        inputLottoNumbers();
    }

    public void countLottoPapers(UserMoney userMoney) {
        inputMoney.lottoCount(userMoney);
    }

    public void pickRandomLottos(int lottoPapers) {
        PickRandomLotto pickRandomLotto = new PickRandomLotto();

        pickRandomLotto.PickRandomNumber(lottoPapers);
    }

    public void inputLottoNumbers() {
        InputLottoNumber inputLottoNumber = new InputLottoNumber();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> sixLottoNumbers = inputLottoNumber.inputSixNumbers();
        inputBonusNumber.inputBonusNumber(sixLottoNumbers);
    }
}