package lotto.service;

import static lotto.view.InputView.inputMoney;

public class LottoService {
    public static void lottoService() {
        int money;
        try {
            money = inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return;
        }
    }
}
