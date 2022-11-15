package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.PurchaseAmountDto;

public class User {

    private final int purchaseCount;
    private final List<Lotto> lottos;
    private final List<Ranking> rankings;

    private User(PurchaseAmountDto purchaseAmountDto) {
        int purchaseAmount = purchaseAmountDto.getPurchaseAmount();
        this.purchaseCount = purchaseAmount / Lotto.LOTTO_UNIT;
        this.lottos = new ArrayList<>(this.purchaseCount);
        this.rankings = new ArrayList<>(this.purchaseCount);

        purchaseLottos();
    }

    public static User of(PurchaseAmountDto purchaseAmountDto) {
        return new User(purchaseAmountDto);
    }

    private void purchaseLottos() {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }
}
