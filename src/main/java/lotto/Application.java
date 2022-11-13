package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.ConsumerResult;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;

public class Application {
    public static void main(String[] args) {
        PurchaseLotto purchaseLotto = new PurchaseLotto();
        LottoResult lottoResult = new LottoResult();
        ConsumerResult consumerResult = new ConsumerResult();
        List<List<Integer>> totalLotto = purchaseLotto.myLotto(purchaseLotto.inputMoney());
        purchaseLotto.printMyLotto(totalLotto);

    }
}
