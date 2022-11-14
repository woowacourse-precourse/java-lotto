package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private List<Lotto> purchasedLottos;

    public PurchasedLottos(List<Lotto> lottos) {
        validate(purchasePrice);
        int count = getCount(purchasePrice);
        createLottos(count);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    private void createLottos(int count) {
        this.purchasedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            purchasedLottos.add(lotto);
        }
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % LottoCondition.PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    private int getCount(int purchasePrice) {
        return purchasePrice / LottoCondition.PRICE.getNumber();
    }
}
