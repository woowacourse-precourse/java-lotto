package lotto;

import utils.Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Result {
    public static final int PERCENT = 100;
    public static final int ROUND_ONE = 10;
    public static final double ONE_DECIMAL = 10.0;

    private static HashMap<MatchCount, Integer> totalMatchResult = new HashMap<>();
    private int totalPrizeMoney = 0;
    private List<String> resultMessage = new ArrayList<>();

    public Result(List<Lotto> lottoTickets) {
        saveMatchResult(lottoTickets);
        calculatePrizeMoney();
        Output.showResult(resultMessage);
    }

    private void saveMatchResult(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            MatchCount matchResult = LottoNumber.getMatchResult(lotto);
            totalMatchResult.put(matchResult, totalMatchResult.getOrDefault(matchResult, 0)+1);
        }
    }

    public void calculatePrizeMoney() {
        List<Prize> allPrize = Prize.getAllPrize();
        for (Prize prize : allPrize) {
            int countPrize = getPrizeCount(prize.getWinningCount(), prize.getBonusCount());
            sumPrizeMoney(prize.getPrizeMoney(), countPrize);
            saveResultMessage(prize.getMessage(), countPrize);
        }
    }

    private int getPrizeCount(int winningCount, int bonusCount) {
        return totalMatchResult.getOrDefault(new MatchCount(winningCount, bonusCount), 0);
    }

    public void sumPrizeMoney(int prizeMoney, int countPrize) {
        totalPrizeMoney += prizeMoney*countPrize;
    }

    public void calculateReturnOfRate(int price) {
        double returnOfRate = Math.round(((double)totalPrizeMoney/price)*PERCENT* ROUND_ONE)/ ONE_DECIMAL;
        Output.showReturnOfRate(returnOfRate);
    }

    public void saveResultMessage(String message, int countPrize){
        resultMessage.add(message+ " - " + countPrize+"개");
    }
}
