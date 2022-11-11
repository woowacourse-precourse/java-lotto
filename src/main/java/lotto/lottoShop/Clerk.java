package lotto.lottoShop;

import java.util.List;

import static lotto.Enum.Constant.*;

public class Clerk {
    private final MoneyValidator moneyValidator;
    private final LottoMachine lottoMachine;

    public Clerk(MoneyValidator moneyValidator, LottoMachine lottoMachine) {
        this.moneyValidator = moneyValidator;
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> sellLotto(String purchaseAmount) {
        moneyValidator.validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        return lottoMachine.makeLottoGroup(lotto_amount);
    }

    private int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % THOUSAND.getIntValue();
    }

}
