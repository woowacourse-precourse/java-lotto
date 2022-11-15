package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
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
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, 6);
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