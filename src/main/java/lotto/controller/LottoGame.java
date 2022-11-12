package lotto.controller;

import lotto.Data.UserMoney;
import lotto.service.InputMoney;
import lotto.service.PickRandomLotto;

public class LottoGame {
    InputMoney inputMoney = new InputMoney();
    PickRandomLotto pickRandomLotto = new PickRandomLotto();
    public void run() {
        UserMoney userMoney = inputMoney.InputMoney();
        countLottoPapers(userMoney);
        pickRandomLottos(inputMoney.lottoCount);
        pickRandomLotto.checkRandomLottoLists();
    }
    public void countLottoPapers(UserMoney userMoney) {
        inputMoney.lottoCount(userMoney);
    }
    public void pickRandomLottos(int lottoPapers) {
        pickRandomLotto.PickRandomNumber(lottoPapers);
    }
}