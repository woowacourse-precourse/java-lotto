package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticsCompiler {

    private final List<Lotto> ticketList;
    private final LottoWinNumber answer;
    private final int ticketPrice;
    private final int ticketNumber;

    private Map<LottoResult, Integer> lottoResultNumberMap;
    private double rateOfReturn;

    public LottoStatisticsCompiler(List<Lotto> ticketList, LottoWinNumber answer, int ticketPrice) {
        this.ticketList = ticketList;
        this.answer = answer;
        this.ticketPrice = ticketPrice;
        this.ticketNumber = ticketList.size();
        prepare();
    }

    private void prepare() {
        this.lottoResultNumberMap = new HashMap<>();
        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResultNumberMap.put(lottoResult, 0);
        }
        rateOfReturn = 0;
    }

    public LottoStatistics compile() {
        for (Lotto ticket : ticketList) {
            LottoResult key = LottoMarker.produceWinningStatistic(answer, ticket);
            lottoResultNumberMap.put(key, lottoResultNumberMap.get(key) + 1);
        }
        rateOfReturn = calculateRateOfReturn();
        return new LottoStatistics(lottoResultNumberMap,rateOfReturn);
    }

    private double calculateRateOfReturn() {
        int cashPrizeSum = 0;
        for (Map.Entry<LottoResult, Integer> entry : lottoResultNumberMap.entrySet()) {
            cashPrizeSum += entry.getKey().getCashPrize() * entry.getValue();
        }
        return
            Math.round((cashPrizeSum * 10 / (double) (ticketNumber * ticketPrice)) * 100)
                / 10.0;
    }
}
