package lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottos {
    private final List<Lotto> purchaseLottos;

    public PurchaseLottos(int numberOfPurchase) {
        this.purchaseLottos = generateLottoNumbersPurchase(numberOfPurchase);
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    private List<Lotto> generateLottoNumbersPurchase(int numberOfPurchase) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfPurchase; i++) {
            lottos.add(generateValidatedLotto());
        }

        return lottos;
    }

    private Lotto generateValidatedLotto() {
        return new Lotto(new LottoMachine().getRandomNumbers());
    }
}
