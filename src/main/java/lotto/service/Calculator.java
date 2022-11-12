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

    public static float calculateRevenueRate(int revenue, int cost) {
        return ((float)revenue)/((float)cost);
    }

    public static int countIntersection(List<Integer> lst1, List<Integer> lst2) {
        Set<Integer> s1 = new HashSet<>(lst1);
        Set<Integer> s2 = new HashSet<>(lst2);
        s1.retainAll(s2);
        return s1.size();
    }
}
