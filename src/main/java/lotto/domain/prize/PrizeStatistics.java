package lotto.domain.prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.lotto.LottoGenerator;

public class PrizeStatistics {
    private final Map<PrizeType, Integer> prizeStatistics = new EnumMap<>(PrizeType.class);

    public PrizeStatistics() {
        for (PrizeType prizeType : PrizeType.values()) {
            prizeStatistics.put(prizeType, 0);
        }
    }

    public Map<PrizeType, Integer> getPrizeStatistics() {
        return prizeStatistics;
    }

    public int getCount(PrizeType prizeType) {
        return prizeStatistics.get(prizeType);
    }

    public void calculateStatistics(LottoGenerator lottos, Prize prize) {
        for (List<Integer> lotto : lottos.getLottos()) {
            boolean containBonusNumber = false;
            List<Integer> duplicateNumbers = new ArrayList<>(lotto);

            if (duplicateNumbers.contains(prize.getBonusNumber())) {
                containBonusNumber = true;
            }

            duplicateNumbers.retainAll(prize.getPrize());
            increment(PrizeType.getPrizeType(duplicateNumbers.size(), containBonusNumber));
        }
    }

    public void increment(PrizeType prizeType) {
        prizeStatistics.put(prizeType, prizeStatistics.get(prizeType) + 1);
    }
}
