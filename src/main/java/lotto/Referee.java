package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Referee {
    private static final int LOTTO_LENGTH = 6;

    public static List<List<Integer>> Compare(List<List<Integer>> lottos, List<List<String>> winningNumbers) {
        List<List<Integer>> totalResult = new ArrayList<>();
        List<Integer> compareOneResult;
        List<Integer> compareResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        int countCash = 0;
        for (List<Integer> lotto : lottos) {
            compareOneResult = countHitsOne(lotto, winningNumbers);
            for (int i = 0; i < compareResult.size(); i++) {
                compareResult.set(i, compareResult.get(i) + compareOneResult.get(i));
            }
            countCash++;
        }
        totalResult.add(compareResult);
        totalResult.add(Collections.singletonList(countCash));
        return totalResult;
    }

    public static List<Integer> countHitsOne(List<Integer> lotto, List<List<String>> winningNumbers) {
        int countWinningNumHits = 0;
        int countBonusNumHits = 0;
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            if (lotto.contains(Integer.parseInt(winningNumbers.get(0).get(i)))) {
                countWinningNumHits++;
            }
        }
        if (lotto.contains(Integer.parseInt(winningNumbers.get(1).get(0)))) {
            countBonusNumHits++;
        }
        return addResult(countWinningNumHits, countBonusNumHits);
    }

    public static List<Integer> addResult(int countWinningNumHits, int countBonusNumHits) {
        List<Integer> hitResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        if (countWinningNumHits == 5 && countBonusNumHits == 1) {
            hitResult.set(3, 1);
            return hitResult;
        }
        if (countWinningNumHits == LOTTO_LENGTH) {
            hitResult.set(4, 1);
            return hitResult;
        }
        for (int i = 3; i < LOTTO_LENGTH; i++) {
            if (countWinningNumHits == i) {
                hitResult.set(i - 3, 1);
            }
        }
        return hitResult;
    }
}















