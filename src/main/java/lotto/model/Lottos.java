package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final static int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Lottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottos = generateLottos();
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Lotto> generateLottos() {
        int amount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> newLottos = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            newLottos.add(new Lotto(LottoNumberGenerator.generateNumbers()));
        }
        return newLottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
