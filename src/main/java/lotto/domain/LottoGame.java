package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;


public class LottoGame {

    private static final int START_INDEX = 0;

    private final Lotto winningLotto;
    private final int bonusNumber;
    private final List<Lotto> lottoTickets;
    private final Map<Lotto, Integer> rank = new HashMap<>();

    public LottoGame(Lotto winningLotto, int bonusNumber, List<Lotto> lottoTickets) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoTickets = lottoTickets;
    }

    public LottoStatistics checkMatchLotto() {
        IntStream.range(START_INDEX, this.lottoTickets.size())
                .forEach(index -> rank.put(this.lottoTickets.get(index), (int) this.winningLotto.getNumbers().stream()
                        .flatMap(winNumber -> this.lottoTickets.get(index).getNumbers().stream()
                                .filter(Predicate.isEqual(winNumber))).count()));

        return new LottoStatistics(rank, bonusNumber);
    }
}
