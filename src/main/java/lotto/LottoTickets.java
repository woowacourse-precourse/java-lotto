package lotto;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private static final int COUNT_NUM = 1;
    private final List<Lotto> lottos = new ArrayList<>();
    public LottoTickets(int count) {
        getTickets(count);
    }
    public void getTickets(int count) {
        while (count > 0) {
            lottos.add(LottoGenerate.generateLotto());
            count -= COUNT_NUM;
        }
    }
    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(lottos);
    }
    public WinningResult getWinningStatistic(WinningNumbers winningNumbers) {
        List<Ranking> rankings = lottos.stream()
                .map(winningNumbers::calculateRanking)
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
        return new WinningResult(rankings);
    }
}
