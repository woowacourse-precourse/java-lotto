package lotto.model.lottostatistics;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.model.lottoticket.LottoTickets;
import lotto.model.lottoticket.LottoWinningNumber;

public class WinningCalculator {

    public WinningStatistics calculateStatistics(LottoWinningNumber lottoWinningNumber,
            LottoTickets lottoTickets) {

        final Map<Ranking, Long> rankBoard = new EnumMap<>(Ranking.class);

        initStatistics(rankBoard);
        updateStatistics(rankBoard, lottoWinningNumber, lottoTickets);

        return new WinningStatistics(rankBoard);
    }

    private void initStatistics(Map<Ranking, Long> rankBoard) {
        Arrays.stream(Ranking.values())
                .forEach(key -> rankBoard.put(key, 0L));
    }

    private void updateStatistics(Map<Ranking, Long> rankBoard,
            LottoWinningNumber lottoWinningNumber, LottoTickets lottoTickets) {

        List<Ranking> ranks = lottoTickets.compareWith(lottoWinningNumber);

        ranks.forEach(rank -> countRankResult(rankBoard, rank));
    }

    public void countRankResult(Map<Ranking, Long> rankBoard, Ranking rankResult) {

        long targetRank = rankBoard.get(rankResult);

        rankBoard.put(rankResult, targetRank + 1);
    }
}
