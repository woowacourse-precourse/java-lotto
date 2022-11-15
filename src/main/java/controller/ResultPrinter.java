package controller;

import data.NumericData;
import data.OutputData;
import data.PrizeData;
import java.util.List;

public class ResultPrinter {

    List<MatchResult> matchResult;
    int[] prizeCount = new int[PrizeData.values().length];

    public ResultPrinter(List<MatchResult> data) {
        matchResult = data;
    }

    public void printResult(int lottoAmount) {
        countPrize();
        System.out.println(OutputData.WINNING_RESULT.getOutputData());
        System.out.println(OutputData.LINE.getOutputData());
        playPrizeArray();
        printProfitRate(lottoAmount);
    }

    public void playPrizeArray() {
        for (int outputCount = 0; outputCount < prizeCount.length; outputCount++) {
            printPrize(outputCount, prizeCount[outputCount]);
        }
    }

    public void countPrize() {
        for (MatchResult result : matchResult) {
            int winningCount = result.getWinningNumberCount();
            boolean isHavingBonus = result.getIsHavingBonus();
            if (PrizeData.matchWinningCountToPrize(winningCount, isHavingBonus)
                >= 0) { // 위닝카운트와 보너스 번호를 전달
                prizeCount[PrizeData.matchWinningCountToPrize(winningCount, isHavingBonus)]++;
            }
        }
    }

    public void printPrize(int index, int amount) {
        System.out.print(PrizeData.getWinningCount(index));
        System.out.print(OutputData.NUMBER_COUNT.getOutputData());

        if (index == PrizeData.SECOND.getIndex()) {
            System.out.print(OutputData.SECOND_PRIZE.getOutputData());
        }
        System.out.print(" ");
        System.out.print(OutputData.OPEN_BRACKET.getOutputData());
        System.out.print(PrizeData.getPrizeOutput(index));
        System.out.print(OutputData.CLOSE_BRACKET.getOutputData());
        System.out.print(amount);
        System.out.print(OutputData.COUNT.getOutputData());

        System.out.println();
    }

    public void printProfitRate(int lottoAmount) {
        int money = 0;
        int originalMoney = lottoAmount * NumericData.LOTTO_PRICE.getNumericValue();
        double profitRate;
        for (int index = 0; index < prizeCount.length; index++) {
            money = money + (prizeCount[index] * PrizeData.getPrizeMoney(index));
        }
        profitRate = (double) money / originalMoney * 100;
        System.out.print(OutputData.OPEN_PROFIT_RATE.getOutputData());
        System.out.print(profitRate);
        System.out.println(OutputData.CLOSE_PROFIT_RATE.getOutputData());
    }
}
