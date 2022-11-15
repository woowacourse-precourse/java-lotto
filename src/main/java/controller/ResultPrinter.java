package controller;

import data.WinningData;
import java.util.List;

public class ResultPrinter {
    List<WinningData> winningData;

    public ResultPrinter(List<WinningData> data){
        winningData = data;
    }
    public static void printResult(int amount){
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

    public static void printFifthPrize(){
        System.out.println("3개 일치 :");
    }

    public static void printFourthPrize(){

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
