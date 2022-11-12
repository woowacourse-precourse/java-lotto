package lotto.LottoShop;

import lotto.LottoManager.Lotto;

import java.util.List;

import static lotto.Enum.Constant.*;

public class Clerk {
    private final MoneyValidator moneyValidator;
    private final LottoPublishingMachine lottoProvidingMachine;

    public Clerk(MoneyValidator moneyValidator, LottoPublishingMachine lottoProvidingMachine) {
        this.moneyValidator = moneyValidator;
        this.lottoProvidingMachine = lottoProvidingMachine;
    }

    public List<Lotto> sellLotto(String purchaseAmount) {
        moneyValidator.validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        return lottoProvidingMachine.makeLottoGroup(lotto_amount);
    }

    private int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / THOUSAND.getIntValue();
    }

}
