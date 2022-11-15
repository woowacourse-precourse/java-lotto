package lotto;

import java.util.List;

public class RankingService {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;


    RankingService(Lotto winningNumbers, LottoNumber bonusNumber) {
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


}
