package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryCompare {



    public int getMatch(List<Integer> lotto, List<Integer> winning){
        int match = 0;
        for(int i=0; i<lotto.size(); i++){
            if(winning.contains(lotto.get(i)))
                match += 1;
        }
        return match;
    }

    public int getMatchBonus(List lotteryList, int bonus){
        int match = 0;
        for(int i=0; i<lotteryList.size(); i++){
            if(lotteryList.contains(lotteryList.get(i)))
                match += 1;
        }
        return match;
    }

    public List<List> compareNumbers(List<List> userList, List<Integer> winList, int bonus){
        List<List> LotteryResult = new ArrayList<>();

        int lottoCount = 0;
        int bonusCount = 0;
        for (int i = 0; i < userList.size(); i++){
            bonusCount = 0;
            lottoCount = getMatch(userList.get(i), winList);
            if (lottoCount != 6){
                bonusCount = getMatchBonus(userList.get(i), bonus);
            }
            LotteryResult.add(compareResultLottery(lottoCount, bonusCount));
        }
        return LotteryResult;
    }

    public List<Integer> compareResultLottery(int lottoCount, int bonusCount){
        Integer[] account = {0,0,0,0,0};

        if(lottoCount == 6){
            account[0] ++; //1등
        }
        if(bonusCount == 1 && lottoCount == 5){
            account[1] ++; //2등
        }
        if(bonusCount == 0 && lottoCount == 5){
            account[2] ++; //3등
        }
        if(lottoCount == 4){
            account[3] ++; //4등
        }
        if(lottoCount == 3){
            account[4] ++; //5등
        }
        List<Integer> accountLoterry = Arrays.asList(account);

        return accountLoterry;
    }

    public List<Integer> countWinResult(List<List> userLotteryResult){
        List<Integer> winLottery = new ArrayList<>();
        int first=0, second=0, third=0, fourth=0, fifth=0;

        for (int i = 0; i < userLotteryResult.size(); i++) {
            first += Integer.parseInt(String.valueOf(userLotteryResult.get(i).get(0)));
            second += Integer.parseInt(String.valueOf(userLotteryResult.get(i).get(1)));
            third += Integer.parseInt(String.valueOf(userLotteryResult.get(i).get(2)));
            fourth += Integer.parseInt(String.valueOf(userLotteryResult.get(i).get(3)));
            fifth += Integer.parseInt(String.valueOf(userLotteryResult.get(i).get(4)));
        }
        winLottery.add(first);
        winLottery.add(second);
        winLottery.add(third);
        winLottery.add(fourth);
        winLottery.add(fifth);

        return winLottery;
    }

    public static void printPrize(List<Integer> LottoResult) {
        System.out.println("\n당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + LottoResult.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + LottoResult.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + LottoResult.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + LottoResult.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + LottoResult.get(0) + "개");
    }

    public void getPrizeMoney(List<Integer> winLottoResult, int lottoAmount){
        int total = 0;
        int cost = lottoAmount * 1000;
        total += 2000000000 * winLottoResult.get(0);
        total += 30000000 * winLottoResult.get(1);
        total += 1500000 * winLottoResult.get(2);
        total += 50000 * winLottoResult.get(3);
        total += 5000 * winLottoResult.get(4);
        getPrizeRate(total, cost);
    }

    //5.수익률 계산
    public double getPrizeRate(int total_prize, int cost) {
        double rate = (total_prize / (double)cost) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
        return rate;
    }
}
