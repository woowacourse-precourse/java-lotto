package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import utils.Output;

import java.util.HashMap;
import java.util.List;

public class Result {
    public static final int PERCENT = 100;

    private final LottoNumber lottoNumber;
    private HashMap<Prize, Integer> totalMatchResult = new HashMap<>();

    public Result(List<Lotto> lottoTickets, LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
        saveMatchResult(lottoTickets);
        sumPrizeMoney();
        Output.showResult(Prize.makeResultMessage(totalMatchResult));
    }

    private void saveMatchResult(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            Prize prize = Prize.findPrizeType(lotto.getMatchResult(lottoNumber));
            totalMatchResult.put(prize, totalMatchResult.getOrDefault(prize, 0) + 1);
        }
    }

    private long sumPrizeMoney() {
        long totalPrizeMoney = 0;
        for (Prize prize : totalMatchResult.keySet()) {
            int count = totalMatchResult.get(prize);
            totalPrizeMoney += Prize.calculatePrizeMoney(prize, count);
        }
        return totalPrizeMoney;
    }

    public void calculateReturnOfRate(int price) {
        long totalPrizeMoney = sumPrizeMoney();
        double returnOfRate = (double) totalPrizeMoney / price * PERCENT;
        Output.showReturnOfRate(returnOfRate);
    }
}