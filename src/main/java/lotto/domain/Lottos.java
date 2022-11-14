package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstant;
import lotto.util.LottoRank;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private static final int PERCENTAGE = 100;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateNumberOfLotto(lottos);
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getlottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<LottoRank, Integer> getRankCounts(WinningNumber winningNumber) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        getRanks(winningNumber)
                .forEach(lottoRank -> rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1));
        return rankCount;
    }

    public double getRateOfReturn(int prizeMoney) {
        return ((double) prizeMoney / (lottos.size() * LottoConstant.PRICE.getValue())) * PERCENTAGE;
    }

    public List<LottoRank> getRanks(WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.getRank(winningNumber))
                .collect(Collectors.toList());
    }

    public int getTotalPrizeMoney(List<LottoRank> ranks) {
        return ranks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }

    private void validateNumberOfLotto(List<Lotto> lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_LOTTO.getMessage());
        }
    }
}
