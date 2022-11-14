package lotto;

import lotto.Domain.Statistic.Profit;
import lotto.Domain.Statistic.Statistic;
import lotto.Output.Statistic.StatisticOutput;

public class Application {
    public static final String ERROR = "[ERROR]";
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.play();
        Statistic statistic =
                new Statistic(game.sixNum, game.bonusNum, game.publishedLottos);
        StatisticOutput statisticOutput = new StatisticOutput();
        statisticOutput.getStatisticOutput(statistic.prizeRanks);
        Profit profit = new Profit();
        profit.printProfit(statistic.prizeRanks,game.publishedLottos.size());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR+e.getMessage());
        }
    }

}
