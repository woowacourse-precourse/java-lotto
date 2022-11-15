package lotto.service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Calculator {

    private static int costMemory;

    public static int getCost() {
        return costMemory;
    }

    public static int lottoNumbersPerCost(int cost) {
        costMemory = cost;
        return cost/1000;
    }

    public static int scalingStatisticIndex(int cnt, boolean containBonus){
        if(containBonus && cnt<6) {
            cnt-=1;
        }
        if(!containBonus && cnt==6) {
            cnt+=1;
        }
        return cnt;
    }

    public static float calculateRevenueRate(int revenue, int cost) {
        return ((float)revenue)/((float)cost) * 100;
    }

    public static Set<Integer> intersection(List<Integer> lst1, List<Integer> lst2) {
        Set<Integer> s1 = new HashSet<>(lst1);
        s1.retainAll(lst2);
        return s1;
    }
}