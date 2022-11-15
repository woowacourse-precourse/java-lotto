package controller;

import java.util.List;

public class ResultPrinter {
    List<MatchResult> winningData;

    public ResultPrinter(List<MatchResult> data){
        winningData = data;
    }
    public void printResult(int lottoAmount){
        int prizeMoney = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        prizeMoney += printFifthPrize();
        prizeMoney += printFourthPrize();
        prizeMoney += printThirdPrize();
        prizeMoney += printSecondPrize();
        prizeMoney += printFirstPrize();
        printProfitRate(prizeMoney, lottoAmount);
    }

    public int printFifthPrize(){
    }

    public int printFourthPrize(){

    }

    public int printThirdPrize(){

    }

    public int printSecondPrize(){

    }

    public int printFirstPrize(){

    }

    public void printProfitRate(int money, int lottoAmount){

    }
}
