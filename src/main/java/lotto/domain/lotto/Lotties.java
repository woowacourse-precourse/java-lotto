package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Lotties {

    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public Map<LottoRank, Long> generateLottoRankMap(List<Integer> userLotto, int bonusNum) {
        return lotties.stream()
                .map(lotto -> LottoRank.of(lotto.findLottoWinCount(userLotto),
                        lotto.hasBonusNumber(bonusNum)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int count() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }
}
