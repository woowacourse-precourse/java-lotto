package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    
    public <E> Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public List<LottoRank> parseRanks(final Lotto winningLotto, final int bonusNumber) {
        return lottos.stream()
                .map(lotto -> LottoRank.parseRank(lotto.countOfSameNumber(winningLotto), lotto.containsBonusNumber(bonusNumber)))
                .collect(Collectors.toList());
    }
}
