package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Rank;

public class RankingService {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;


    public RankingService(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRanking(Lotto numbers) {
        int matchedNormalNumberCount = numbers.countNumberOfMatchesWith(winningNumbers);
        boolean haveBonusNumber = numbers.have(bonusNumber);

        for (Rank rank : Rank.values()) {
            if (haveBonusNumber && Rank.SECOND.getMatchedNumberCount() == matchedNormalNumberCount) {
                return Rank.SECOND;
            }
            if (rank.getMatchedNumberCount() == matchedNormalNumberCount) {
                return rank;
            }
        }
        return Rank.UN_RANK;
    }

    public Rank[] calculateRankings(List<Lotto> lottoTickets) {
        for (Lotto ticket : lottoTickets) {
            Rank rank = calculateRanking(ticket);
            rank.increaseCount();
        }
        return Rank.values();
    }

    public int getTotalPrize(Rank[] rankings) {
        int prize = 0;

        for (Rank rank : rankings) {
            prize += rank.getPrize() * rank.getCount();
        }

        return prize;
    }

    public double getProfitRateFrom(Money money, Rank[] rankings) {
        return ((double) getTotalPrize(rankings) / money.getMoney()) * 100;
    }

}
