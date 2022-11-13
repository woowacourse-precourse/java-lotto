package lotto.controller;

import lotto.console.Output;
import lotto.domain.*;

import java.util.List;

public class Processing {
    private final FindNumber findNumber = new FindNumber();
    private final Rank rank = new Rank();
    private final Output output = new Output();
    private final Counter counter = new Counter();
    private final Calculator calculator = new Calculator();
    private final Reward reward = new Reward();


    public void printAndDataProcessing(List<Lotto> lottos, List<Integer> winNumbers, int bonus, int money) {
        output.printWinningStatistics();
        output.printLine();
        List<Integer> ranking = makeRanking(lottos, winNumbers, bonus);
        printNumberOfMatches(ranking);
        output.reportRateOfReturn(calculateTotalReturn(ranking, money));

    }

    private double calculateTotalReturn(List<Integer> ranking, int money) {

        return calculator.df(reward.rewardMoneys(ranking), money);

    }

    private List<Integer> makeRanking(List<Lotto> lottos, List<Integer> winNumbers, int bonus) {
        List<Integer> sameNumber = findNumber.findSameNumber(lottos, winNumbers, bonus);

        return rank.rankNumbers(sameNumber);

    }

    private void printNumberOfMatches(List<Integer> ranking) {
        output.printThree(counter.countFifth(ranking));
        output.printFour(counter.countFourth(ranking));
        output.printFive(counter.countThird(ranking));
        output.printFiveFlus(counter.countSecond(ranking));
        output.printSix(counter.countFirst(ranking));
    }


}
