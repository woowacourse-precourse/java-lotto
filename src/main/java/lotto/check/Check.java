package lotto.check;

import lotto.Game;
import lotto.view.Print;

import java.util.List;

public class Check {
    public static int luckyCount = 0;
    public static int threeLuckyCount = 0;
    public static int fourLuckyCount = 0;
    public static int fiveLuckyCount = 0;
    public static int bonusLuckyCount = 0;
    public static int sixLuckyCount = 0;
    public static double plusPercent = 0.0;
    public static int amount = 0;

    public static void checkBonus(int bonus){
        if(Game.luckyNumber.contains(bonus)){
            bonusLuckyCount++;
            fiveLuckyCount = -1;
        }
    }
    public static void compareLucky(List<Integer> luckyNumber, int bonus){
        for(int i=0;i<Game.autoNumber.size();i++){
            luckyCount=0;
            List<Integer> auto = Game.autoNumber.get(i);
            compareAuto(auto,luckyNumber,bonus);
        }
    }
    public static void compareAuto(List<Integer> auto,List<Integer> luckyNumber,int bonus){
        for(int i=0;i<luckyNumber.size();i++){
            findLucky(auto,luckyNumber,i,bonus);
        }
        countLucky(luckyCount,bonus);
    }
    public static void countLucky(int luckyCount,int bonus){
        if(luckyCount == 3){
            threeLuckyCount++;
        }else if(luckyCount == 4){
            fourLuckyCount++;
        }else if(luckyCount == 5){
            Check.checkBonus(bonus);
            fiveLuckyCount++;
        }else if(luckyCount == 6){
            sixLuckyCount++;
        }
    }
    public static void findLucky(List<Integer> auto,List<Integer> luckyNumber,int index,int bonus){
        if(luckyNumber.contains(auto.get(index))){
            luckyCount++;
        }
    }

    public static void printResult(){
        Print.viewTotalLucky(threeLuckyCount,fourLuckyCount,fiveLuckyCount,bonusLuckyCount,sixLuckyCount);
        amountPlus(threeLuckyCount,fourLuckyCount,fiveLuckyCount,bonusLuckyCount,sixLuckyCount);
        Print.viewPlusPercent(plusPercent);
    }
    public static void amountPlus(int threeLuckyCount,int fourLuckyCount,int fiveLuckyCount,int bonusLuckyCount,int sixLuckyCount){
        amount = threeLuckyCount * 5000 + fourLuckyCount * 50000 + fiveLuckyCount * 1500000 + bonusLuckyCount * 30000000 + sixLuckyCount * 2000000000;
        plusPercent = (double) amount/(double)Game.cashAmount * 100.0;
    }
}
