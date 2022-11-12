package lotto;

import view.InputView;

public class LottoStore {
    public int calculateLottoCount() {
        InputView inputView = new InputView();
        int money = inputView.inputMoney();
        int lottoCount = money / 1000;
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        return lottoCount;
    }
}
