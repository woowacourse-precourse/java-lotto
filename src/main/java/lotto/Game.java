package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.check.Check;
import lotto.check.Validator;
import lotto.domain.Lotto;
import lotto.view.Print;
import lotto.exception.Exception;

import java.util.*;
public class Game {
    public static List<List<Integer>> autoNumber = new ArrayList<>();
    public static List<Integer> luckyNumber = new ArrayList<>();
    public static int luckyCount = 0;
    public static int threeLuckyCount = 0;
    public static int fourLuckyCount = 0;
    public static int fiveLuckyCount = 0;
    public static int bonusLuckyCount = 0;
    public static int sixLuckyCount = 0;
    public static int amount = 0;
    public static int cashAmount = 0;

    public static void gameStart() {
        Print.viewGameStart();
        String cash = Input.input();
        Validator.validateCash(cash);
        Lotto.myLotto(cash);
        cashAmount = Integer.parseInt(cash);
        luckyNumber = Lotto.getLuckyNumber();
        int bonus = Lotto.getBonusNumber();

        compareLucky(luckyNumber,bonus);
        //당첨 내역 출력
        Print.viewTotalLucky(threeLuckyCount,fourLuckyCount,fiveLuckyCount,bonusLuckyCount,sixLuckyCount);
        // 수익률 계산
        amountPlus(threeLuckyCount,fourLuckyCount,fiveLuckyCount,bonusLuckyCount,sixLuckyCount);
    }
    public static void amountPlus(int threeLuckyCount,int fourLuckyCount,int fiveLuckyCount,int bonusLuckyCount,int sixLuckyCount){
        amount = threeLuckyCount * 5000 + fourLuckyCount * 50000 + fiveLuckyCount * 1500000 + bonusLuckyCount * 30000000 + sixLuckyCount * 2000000000;
        double plusPercent = (double) amount/(double)cashAmount * 100.0;
        Print.viewPlusPercent(plusPercent);
    }
    public static void compareLucky(List<Integer> luckyNumber,int bonus){
        for(int i=0;i<autoNumber.size();i++){
            luckyCount=0;
            List<Integer> auto = autoNumber.get(i);
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

    public static void myAutoLotto(int myLottoCount){
        Print.viewUserLottoCount(myLottoCount);
        for(int i=0;i<myLottoCount;i++){
            List<Integer> getNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            autoNumber.add(getNumber);
        }
        Print.viewAutoLotto(autoNumber);
    }
}
