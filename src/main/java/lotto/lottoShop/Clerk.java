package lotto.lottoShop;

import java.util.List;

import static lotto.Enum.Constant.*;

public class Clerk {
    private final MoneyValidator moneyValidator;
    private final LottoProvidingMachine lottoProvidingMachine;

    public Clerk(MoneyValidator moneyValidator, LottoProvidingMachine lottoProvidingMachine) {
        this.moneyValidator = moneyValidator;
        this.lottoProvidingMachine = lottoProvidingMachine;
    }

    public List<Lotto> sellLotto(String purchaseAmount) {
        moneyValidator.validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        return lottoProvidingMachine.makeLottoGroup(lotto_amount);
    }

    private int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % THOUSAND.getIntValue();
    }

}
