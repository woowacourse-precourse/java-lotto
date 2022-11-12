package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckLottosPrize {
    private  List<Lotto> lottos;
    private  Lotto winningNumbers;
    private  Integer bonusNumber;
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

    public Map<String, Integer> checkTotalPrize(List<Lotto> lottos) {
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
        if (answerCount == 5) {
            if (lotto.get().contains(bonusNumber)) {
                return PrizeRank.SECOND.name();
            }
            return PrizeRank.THIRD.name();
        }
        for (PrizeRank value : PrizeRank.values()) {
            if (value.getAnswerCount() == answerCount) {
                return value.name();
            }
        }
        return null;
    }

    private int getAnswerCount(Lotto lotto) {
        lotto.get().retainAll(winningNumbers.get());
        return lotto.get().size();
    }

    public Map<String, Integer> getTotalPrize() {
        return totalPrize;
    }
}
