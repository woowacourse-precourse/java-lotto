package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.InputBonusNumber;
import view.InputUserMoney;
import view.InputWinningLottoNumber;
import view.OutputView;

public class LottoGame {

    List<List<Integer>> buyLottoList = new ArrayList<>();
    List<Integer> winningLottoList = new ArrayList<>();
    List<Integer> matchCountList = new ArrayList<>();
    static List<Integer> rankedList = new ArrayList<>();
    List<Integer> moneyRankedList = new ArrayList<>();
    int bonusNumber;
    static long sumMoney;
    static float yield;

    public static List<Integer> getRankedList() {
        return rankedList;
    }

    public void Game() {

        setting();
        for (int index = 0; index < buyLottoList.size(); index++) {
            List<Integer> nowLottoList = buyLottoList.get(index);
            matchCountList.add(matchCount(winningLottoList, nowLottoList, bonusNumber));
        }

        calculate(matchCountList);
        OutputView.printStatistics();

    }

    public static long getSumMoney() {
        return sumMoney;
    }

    public static float getYield() {
        return yield;
    }

    private  void calculate(List<Integer> matchCountList) {

        countingRank(matchCountList);
        sumMoney = calculateSumMoney(rankedList);
        yield = setYield((float) sumMoney);

    }

    private float setYield(float sumMoney) {
        float yield = sumMoney / (float) InputUserMoney.getUserMoney() * 100;
        return yield;
    }

    private long calculateSumMoney(List<Integer> rankedList) {
         moneyRankedList = Arrays.asList(5000, 50000, 1500000, 2000000000, 30000000);
        long sumGetMoney=0;
        for(int i=0; i<rankedList.size(); i++){
            Integer nowRankMoney = moneyRankedList.get(i);
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
                return 7;
            }
        }
        return Math.toIntExact(count);
    }

    public static boolean isInBonusNumber(List<Integer> nowBuyLottoList, int bonusNumber){
        return nowBuyLottoList.contains(bonusNumber);
    }


}
