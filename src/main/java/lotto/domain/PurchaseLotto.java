package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

public class PurchaseLotto {
    public static void inputAmount() {
        LottoView.inputLottoAmount();
        String amount = Console.readLine();
        int lottoCnt = Validator.validateMoney(amount) / 1000;
    }

}
