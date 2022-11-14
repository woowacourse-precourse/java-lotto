package lotto.LottoShop;

import lotto.LottoManager.Lotto;

import java.util.List;

import static lotto.Enum.Constant.*;

public class Clerk {
    private final MoneyValidator moneyValidator;
    private final LottoPublishingMachine lottoPublishingMachine;

    public Clerk(MoneyValidator moneyValidator, LottoPublishingMachine lottoPublishingMachine) {
        this.moneyValidator = moneyValidator;
        this.lottoPublishingMachine = lottoPublishingMachine;
    }

    public List<Lotto> sellLotto(String purchaseAmount) {
        moneyValidator.validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        List<Lotto> lotto_group = lottoPublishingMachine.publishLottoGroup(lotto_amount);

        printPurchasedLotto(lotto_group);

        return lotto_group;
    }

    private int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / THOUSAND.getIntValue();
    }

    private void printPurchasedLotto(List<Lotto> lotto_group) {
        System.out.println(lotto_group.size() + MESSAGE_PURCHASE.getValue());
        lotto_group.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
