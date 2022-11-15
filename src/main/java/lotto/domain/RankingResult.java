package lotto.domain;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map;

public class RankingResult {
    private Map<Ranking, Integer> rankings;

    DecimalFormat decFormat = new DecimalFormat("###,###");

    public RankingResult() {
        rankings = new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            rankings.put(ranking, 0);
        }
    }

    public void update(Ranking ranking) {
        rankings.put(ranking, rankings.get(ranking) + 1);

    }

    public Map<Ranking, Integer> getRankings() {
        return rankings;
    }

    public double getProfit(Money money) {
        double profit = profitMoney();
        return profitRates(profit, money.getMoney());
    }

    public String result() {

        String outputString = "";
        for (Ranking ranking : Ranking.winningResults()) {
            if (ranking == Ranking.SECOND) {
                outputString +=
                        ranking.getMatchCount() + "개 일치, 보너스 볼 일치 (" + decFormat.format(ranking.getPrize()) + "원) - "
                                + rankings.get(ranking) + "개\n";
                continue;
            }
            outputString +=
                    ranking.getMatchCount() + "개 일치 (" + decFormat.format(ranking.getPrize()) + "원) - " + rankings.get(
                            ranking) + "개\n";
        }

        return outputString;
    }

    private double profitRates(double profit, int value) {
        return (profit / value) * 100;
    }


    private double profitMoney() {
        double profit = 0;
        for (Ranking ranking : Ranking.winningResults()) {
            profit += ranking.getPrize() * rankings.get(ranking);
        }
        return profit;
    }
}
