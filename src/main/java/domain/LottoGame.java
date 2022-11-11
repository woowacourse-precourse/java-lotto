package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputBonusNumber;
import view.InputWinningLottoNumber;

public class LottoGame {

    List<List<Integer>> buyLottoList = new ArrayList<>();
    List<Integer> winningLottoList = new ArrayList<>();
    List<Integer> matchCountList = new ArrayList<>();
    List<Integer> rankedList = new ArrayList<>();
    List<Integer> moneyRankedList = new ArrayList<>();
    int bonusNumber;


    public void Game() {

        setting();
        for (int index = 0; index < buyLottoList.size(); index++) {
            List<Integer> nowLottoList = buyLottoList.get(index);
            matchCountList.add(matchCount(winningLottoList, nowLottoList, bonusNumber));
        }

        calculate(matchCountList);
    }

    private  void calculate(List<Integer> matchCountList) {

        countingRank(matchCountList);
        int sumMoney = calculateSumMoney(rankedList);
        System.out.println("sumMoney = " + sumMoney);

    }

    private int calculateSumMoney(List<Integer> rankedList) {
        List<Integer> money = Arrays.asList(5000, 50000, 1500000, 2000000000, 30000000);
        int sumGetMoney=0;
        for(int i=0; i<rankedList.size(); i++){
            Integer nowRankMoney = money.get(i);
            Integer howManyRanked = rankedList.get(i);
            sumGetMoney += nowRankMoney * howManyRanked;
        }

        return sumGetMoney;
    }

    private void countingRank(List<Integer> matchCountList) {
        for(int j=3; j<=7; j++){
            int finalJ = j;
            rankedList.add((int) matchCountList.stream().filter(n -> n == finalJ).count());
        }
        System.out.println("rankedList = " + rankedList);
    }

    public void setting() {
        this.buyLottoList = BuyLottoList.getBuyLottoList();
        this.winningLottoList = InputWinningLottoNumber.getWinningLottoList();
        this.bonusNumber = InputBonusNumber.getBonusNumber();
    }

    public static Integer matchCount(List<Integer> winningLottoList,
        List<Integer> nowBuyLottoList, int bonusNumber) {
        long count = winningLottoList.stream().filter(n -> nowBuyLottoList.contains(n)).count();
        if(count==5){
            if(isInBonusNumber(nowBuyLottoList, bonusNumber)){
                System.out.println("count = " + 7);
                return 7;
            }
        }
        System.out.println("count = " + count);
        return Math.toIntExact(count);
    }

    public static boolean isInBonusNumber(List<Integer> nowBuyLottoList, int bonusNumber){
        return nowBuyLottoList.contains(bonusNumber);
    }


}
