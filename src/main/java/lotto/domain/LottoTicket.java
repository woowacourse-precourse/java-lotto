package lotto.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final List<LottoNumbers> lottoTickets = new ArrayList<>();

    public LottoTicket(int count) {
        generateTickets(count);
    }

    private void generateTickets(int count) {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoNumbers());
        }
    }

    public List<LottoNumbers> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public WinningResult calculateWinningStatistic(WinningNumbers winningNumbers) {
        List<Ranking> rankings = lottoTickets.stream()
                .map(winningNumbers::calculateRanking)
                .filter(Objects::nonNull)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        return new WinningResult(rankings);
    }
}