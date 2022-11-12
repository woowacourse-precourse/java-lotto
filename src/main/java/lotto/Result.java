package lotto;

import utils.Output;

import java.util.HashMap;
import java.util.List;

public class Result {
    public static final int PERCENT = 100;
    public static final int ROUND_ONE = 10;
    public static final double ONE_DECIMAL = 10.0;

    private static HashMap<Prize, Integer> totalMatchResult = new HashMap<>();
    private int totalPrizeMoney = 0;

    public Result(List<Lotto> lottoTickets) {
        saveMatchResult(lottoTickets);
        sumPrizeMoney();
        Output.showResult(Prize.makeResultMessage(totalMatchResult));
    }

    private void saveMatchResult(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            Prize prize = Prize.findPrizeType(LottoNumber.getMatchResult(lotto));
            totalMatchResult.put(prize, totalMatchResult.getOrDefault(prize, 0) + 1);
        }
    }

    public void sumPrizeMoney() {
        for (Prize prize : totalMatchResult.keySet()) {
            int count = totalMatchResult.get(prize);
            totalPrizeMoney += Prize.getPrizeMoney(prize, count);
        }
    }

    public void calculateReturnOfRate(int price) {
        double returnOfRate = Math.round(((double) totalPrizeMoney / price) * PERCENT * ROUND_ONE) / ONE_DECIMAL;
        Output.showReturnOfRate(returnOfRate);
    }
}
