package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckLottosPrize {
    private static final int LOTTO_LENGTH = 6;
    private final List<Lotto> lottos;
    private final Lotto winningNumbers;
    private final Integer bonusNumber;
    private Map<String, Integer> totalPrize;

    public CheckLottosPrize(List<Lotto> lottos, Lotto winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        initTotalPrize();
        checkTotalPrize(lottos);
    }

    private void initTotalPrize() {
        totalPrize = new HashMap<>();
        for (PrizeRank value : PrizeRank.values()) {
            totalPrize.put(value.name(), 0);
        }
    }

    private Map<String, Integer> checkTotalPrize(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String rank = getRank(lotto);
            if (totalPrize.containsKey(rank)) {
                totalPrize.put(rank, totalPrize.get(rank) + 1);
            }
        }
        return totalPrize;
    }

    private String getRank(Lotto lotto) {
        int answerCount = getAnswerCount(lotto);
        PrizeRank[] values = PrizeRank.values();
        for (PrizeRank value : values) {
            if (value.getAnswerCount() == answerCount) {
                return value.name();
            }
        }
        return null;
    }

    private int getAnswerCount(Lotto lotto) {
        lotto.get().retainAll(winningNumbers.get());
        return LOTTO_LENGTH - lotto.get().size();
    }

    public Map<String, Integer> getTotalPrize() {
        return totalPrize;
    }
}
