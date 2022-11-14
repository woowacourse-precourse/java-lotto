package lotto.view;

import lotto.Lotto;
import lotto.MyLottoList;

public class LottoView {
    public static int inputMoney() {
        int money = Integer.parseInt(AppView.inputLine());
        if(ValidateView.isPossibleMoney(money)) {
            return money;
        }

        return 0;
    }

    public static void outputLottoList(MyLottoList myLottoList) {
        for(Lotto lotto : myLottoList.getLotto()) {
            AppView.outputLine(String.valueOf(lotto));
        }
    }
}
