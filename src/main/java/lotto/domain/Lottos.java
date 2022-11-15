package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final String DELIMITER = "\n";

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public EnumMap<LottoRank, Integer> getLottoRanks(Lotto winningLotto, int bonusNumber) {
        EnumMap<LottoRank, Integer> lottoRanks = initializeLottoRanks();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.findLottoRank(winningLotto, bonusNumber);
            lottoRanks.put(lottoRank, lottoRanks.get(lottoRank) + 1);
        }

        return lottoRanks;
    }

    private EnumMap<LottoRank, Integer> initializeLottoRanks() {
        EnumMap<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);

        for (LottoRank rank : LottoRank.values()) {
            lottoRanks.put(rank, 0);
        }

        return lottoRanks;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
