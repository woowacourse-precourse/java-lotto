package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstant;
import lotto.util.LottoRank;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int PERCENTAGE = 100;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateNumberOfLotto(lottos);
        this.lottos = lottos;
    }

    public double getRateOfReturn(long totalPrizeMoney) {
        return ((double) totalPrizeMoney / (lottos.size() * LottoConstant.PRICE.getValue())) * PERCENTAGE;
    }

    public long getTotalPrizeMoney(Map<LottoRank, Integer> rankCount) {
        return rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getRankCounts(WinningNumber winningNumber) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        lottos.forEach(lotto ->
                rankCount.put(
                        lotto.getRank(winningNumber),
                        rankCount.getOrDefault(lotto.getRank(winningNumber), 0) + 1));
        return rankCount;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private void validateNumberOfLotto(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_LOTTO.getMessage());
        }
    }
}
