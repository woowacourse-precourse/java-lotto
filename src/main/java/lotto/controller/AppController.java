package lotto.controller;

import lotto.MyLottoList;
import lotto.view.AppView;
import lotto.view.LottoView;

import static lotto.controller.LottoController.*;

public class AppController {
    MyLottoList myLottoList;

    public void run() {
        AppView.outputLine("구입금액을 입력해 주세요.");
        int money = LottoView.inputMoney();
        AppView.outputLine("");
        myLottoList = generateMyLottoInstance(money);
        AppView.outputLine(Integer.toString(myLottoList.getNumber()) + "개를 구매했습니다.");
        generateMyLottoList(myLottoList);
    }
}
