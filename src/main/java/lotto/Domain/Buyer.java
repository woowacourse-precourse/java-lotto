package lotto.Domain;

import static lotto.Utils.Constant.*;

import java.util.*;
import lotto.Utils.Util;
import lotto.Utils.Validator.BuyerValidator;

public class Buyer {

    private final int START_NUM = 1;
    private final int END_NUM = 45;

    private int purchaseAmount;
    private int purchaseCount;
    private List<Lotto> lottoWallet;

    public Buyer(String purchaseAmount) {
        new BuyerValidator(purchaseAmount);
        this.purchaseAmount = Util.getInt(purchaseAmount);
        this.purchaseCount = Calculator.divide1000(this.purchaseAmount);
        buyLotto();
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottoWallet() {
        return lottoWallet;
    }

    private void buyLotto() {
        this.lottoWallet = new ArrayList<>();
        for (int i = ZERO; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(Util.generateRandomNum(START_NUM, END_NUM, NUMBERS_OF_LOTTO));
            lottoWallet.add(lotto);
        }
    }
}
