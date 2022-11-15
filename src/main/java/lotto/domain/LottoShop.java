package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.ERROR;
import lotto.ui.LottoShopView;

public class LottoShop {

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> buy(int money) {
        validate(money);

        int purchaseQuantity = getPurchaseQuantity(money);
        List<Lotto> lottos = createLottos(purchaseQuantity);

        printLotto(lottos);

        return lottos;
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR.IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private int getPurchaseQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int purchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            List<Integer> lottoNumbers = NumberGenerator.createUniqueRandomNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    private void printLotto(List<Lotto> lottos) {
        LottoShopView.printLottos(lottos);
        LottoShopView.printLottos(lottos);
    }
}
