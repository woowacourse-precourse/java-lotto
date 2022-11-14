package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.MAX_NUM;
import static lotto.domain.Lotto.MIN_NUM;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int count) {
        generateTickets(count);
    }

    private void generateTickets(int count) {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 6);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public WinningResult calculateWinningStatistic(WinningNumber winningNumber) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            Ranking ranking = winningNumber.calculateRanking(lotto);
            rankings.add(ranking);
        }
        return new WinningResult(rankings);
    }
}