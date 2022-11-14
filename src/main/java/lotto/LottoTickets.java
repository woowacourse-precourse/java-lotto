package lotto;

import domain.LottoResult;
import domain.Ranking;
import domain.WinningTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int BONUS_BALL_CHECK_CONDITION = 5;
    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Ranking> getResult(WinningTicket winningTicket) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            int sameCount = lotto.calculateSameCount(winningTicket);
            boolean hasBonusNumber = checkBonus(winningTicket, lotto, sameCount);
            rankings.add(Ranking.findRanking(sameCount, hasBonusNumber));
        }
        return rankings;
    }

    private boolean checkBonus(WinningTicket winningTicket, Lotto lotto, int count) {
        boolean bonus = false;
        if (count == BONUS_BALL_CHECK_CONDITION) {
            bonus = winningTicket.checkBonus(lotto);
        }
        return bonus;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
