package controller;

import data.PrizeData;
import java.util.List;

public class ResultPrinter {
    List<MatchResult> matchResult;
    int[] prizeCount = new int[PrizeData.values().length];
    public ResultPrinter(List<MatchResult> data){
        matchResult = data;
    }
    public void printResult(int lottoAmount){
        int prizeMoney = 0;
        countPrize();
        System.out.println("당첨 통계");
        System.out.println("---");
        printFifthPrize();
        printFourthPrize();
        printThirdPrize();
        printSecondPrize();
        printFirstPrize();
    }

    public void countPrize(){
        for(MatchResult result : matchResult){
            int winningCount = result.getWinningNumberCount();
            boolean isHavingBonus = result.getIsHavingBonus();
            if(PrizeData.matchWinningCountToPrize(winningCount, isHavingBonus) >= 0) { // 위닝카운트와 보너스 번호를 전달
                prizeCount[PrizeData.matchWinningCountToPrize(winningCount, isHavingBonus)] ++;
            }
        }
    }

    public void printPrize(int index, int amount){

    }
}
