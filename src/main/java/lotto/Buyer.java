package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.type.Rank;

public class Buyer {
    private final int purchaseMoney;
    private final List<Lotto> lottos;

    public Buyer(int purchaseMoney, List<Lotto> lottos) {
        validateForSize(lottos);
        this.purchaseMoney = purchaseMoney;
        this.lottos = lottos;
    }

    private void validateForSize(List<Lotto> lottos) {
        if (lottos.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 복권은 한장이상 사야됩니다.");
        }
    }

    public List<Rank> getLottosRank(List<Integer> winningNumbers, int bonusNumber) {
        List<Rank> lottosRank = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottosRank.add(lotto.getRank(winningNumbers, bonusNumber));
        }

        return lottosRank;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
