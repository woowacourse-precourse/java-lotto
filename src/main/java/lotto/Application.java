package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.presentation.LottoController;
import lotto.presentation.dto.PurchaseAmount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController=LottoController.getInstance();
        lottoController.run();
        lottoController.countPurchasedLotto(new PurchaseAmount(Console.readLine()));
        lottoController.purchaseLotto();
    }
}
