package lotto.controller;

import lotto.MyLottoList;
import lotto.PrizeLotto;
import lotto.view.AppView;
import lotto.view.LottoView;

import static lotto.controller.LottoController.*;

public class AppController {
    MyLottoList myLottoList;
    PrizeLotto prizeLotto;
    int money;

    public void run() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        money = LottoView.inputMoney();
        AppView.outputLine("");
        myLottoList = generateMyLottoInstance(money);
        AppView.outputLine((myLottoList.getNumber()) + "개를 구매했습니다.");
        generateMyLottoList(myLottoList);
        LottoView.outputLottoList(myLottoList);
        AppView.outputLine("");
        AppView.outputLine("당첨 번호를 입력해 주세요.");
        prizeLotto = generatePrizeLottoInstance();
    }
}
