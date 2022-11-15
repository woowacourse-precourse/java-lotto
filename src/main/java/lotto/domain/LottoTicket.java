package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {

    private final List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = new ArrayList<>(lottoTicket);
    }

    public List<Lotto> lottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    public EnumMap<LottoRanking, Integer> checkLottoTicketWinningCountByRank(WinningNumbers winningNumbers) {
        EnumMap<LottoRanking, Integer> winningCountByRank = initializeWinningCount();
        List<Integer> winningNumber = winningNumbers.winningNumbers();
        Number bonusNumber = winningNumbers.bonusNumber();

        for (Lotto lotto : lottoTicket) {
            LottoRanking rank = lotto.checkWinningResult(winningNumber, bonusNumber);
            addWinningResultCount(winningCountByRank, rank);
        }
        return winningCountByRank;
    }

    private EnumMap<LottoRanking, Integer> initializeWinningCount() {
        return new EnumMap<>(Map.ofEntries(
                Map.entry(LottoRanking.FIRST, 0),
                Map.entry(LottoRanking.SECOND, 0),
                Map.entry(LottoRanking.THIRD, 0),
                Map.entry(LottoRanking.FOURTH, 0),
                Map.entry(LottoRanking.FIFTH, 0)
        ));
    }

    private static void addWinningResultCount(EnumMap<LottoRanking, Integer> winningResult, LottoRanking lottoRank) {
        if (lottoRank == LottoRanking.FAIL) {
            return;
        }
        winningResult.put(lottoRank, winningResult.getOrDefault(lottoRank, 0) + 1);
    }
}
