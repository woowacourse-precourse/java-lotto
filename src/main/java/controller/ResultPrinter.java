package controller;

import java.util.List;

public class ResultPrinter {
    List<MatchResult> winningData;

    public ResultPrinter(List<MatchResult> data){
        winningData = data;
    }
    public void printResult(int amount){
        int money = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        printFifthPrize();
        printFourthPrize();
        printThirdPrize();
        printSecondPrize();
        printFirstPrize();
        printProfitRate();
    }

    public void printFifthPrize(){
        System.out.print("3개 일치 :");
    }

    public void printFourthPrize(){
        System.out.print("4개 일치 : ");

    }

    public static void printThirdPrize(){

    }

    public static void printSecondPrize(){

    }

    public static void printFirstPrize(){
    }

    public static void printProfitRate(){

    }
}
