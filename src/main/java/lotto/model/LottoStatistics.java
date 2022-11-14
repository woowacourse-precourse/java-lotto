package lotto.model;

import lotto.constant.Rank;
import lotto.constant.WinPrize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static int[] same;
    private static int[] bonus;
    public static Map<Rank, Integer> rankMap;
    private static int idx;

    private static int revenue;
    public static double revenueRate;

    public static void init(){
        idx = 0;
        revenue = 0;
        revenueRate = 0;
        same = new int[LottoResult.count+1];
        bonus = new int[LottoResult.count+1];
        rankMap = new HashMap<>();
        initRankMap();
    }

    private static void initRankMap() {
        rankMap.put(Rank.ONE, 0);
        rankMap.put(Rank.TWO, 0);
        rankMap.put(Rank.THREE, 0);
        rankMap.put(Rank.FOUR, 0);
        rankMap.put(Rank.FIVE, 0);
    }

    public static void calculateRank(){
        init();
        List<Lotto> lottos = LottoResult.lottos;
        Lotto winNumbers = LottoResult.winNumber;
        for (Lotto lotto : lottos) {
            checkContains(winNumbers, lotto);
            idx++;
        }
        makeRankMap();
        calculateRevenueRate();
    }

    private static void makeRankMap() {
        for(int i=0;i<same.length;i++){
            int n = same[i];
            if(n==3) rankMap.put(Rank.FIVE,rankMap.getOrDefault(5,0)+1);
            if(n==4) rankMap.put(Rank.FOUR, rankMap.getOrDefault(4,0)+1);
            if(n==5 && bonus[i] != 1) rankMap.put(Rank.THREE, rankMap.getOrDefault(3, 0)+1);
            if(n==5 && bonus[i] == 1) rankMap.put(Rank.TWO, rankMap.getOrDefault(2,0)+1);
            if(n==6) rankMap.put(Rank.ONE, rankMap.getOrDefault(1, 0)+1);
        }
    }

    public static void checkContains(Lotto winNumbers, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        for (Integer winNumber : winNumbers.getNumbers()) {
            if(numbers.contains(winNumber)) same[idx] += 1;
            if(numbers.contains(LottoResult.bonusNumber)) bonus[idx] =1;
         }
    }

    private static void calculateRevenueRate(){
        revenue += rankMap.get(Rank.ONE)* WinPrize.FIRST_PRIZE;
        revenue += rankMap.get(Rank.TWO)* WinPrize.SCEOND_PRIZE;
        revenue += rankMap.get(Rank.THREE)* WinPrize.THIRD_PRIZE;
        revenue += rankMap.get(Rank.FOUR)* WinPrize.FOURTH_PRIZE;
        revenue += rankMap.get(Rank.FIVE)* WinPrize.FIFTH_PRIZE;
        LottoStatistics.revenueRate = 100 * (double)revenue/(double)LottoResult.purchaseAmount;
    }
}
