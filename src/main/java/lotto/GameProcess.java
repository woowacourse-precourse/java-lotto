package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Service;
import lotto.view.Input;
import lotto.view.Output;

public class GameProcess {
    public static void gameStart() {
        Output.gameStart();
        String payMoney = Input.input();
        int countPurchasing = Service.inputMoney(payMoney);
        List<List<Integer>> purchasedLottos = Service.makeLottoByRandomNumbers(countPurchasing);
        Output.informationOnPurchasedLottoNumbers(purchasedLottos);
//        Output.informationOnPurchasedLottoNumbers(countPurchasing);
//        String inputUserNumber = Input.input();
//        Lotto.inputWinningNumbers();
    }
}
