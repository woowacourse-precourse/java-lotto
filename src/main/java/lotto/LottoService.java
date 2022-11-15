package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    public static HashMap<Integer, List<Integer>> makeLotto(int count){
        HashMap<Integer, List<Integer>> lotties = new HashMap<>();
        for (int i = 0; i < count; i++) {
            lotties.put(i, makeRandomNumber());
        }
        return lotties;
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45,6);
        Collections.sort(numbers);
        return numbers;
    }

    public static int calculateLotto(int money){
        if (money%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다");
        }
        return money/1000;
    }
    public static List<Integer> compare(List<Integer> lotto, List<Integer> winningNumbers, int bonusNumber){
        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lotto.contains(winningNumbers.get(i))){
                count++;
            }
        }
        result.add(count);
        result.add(0);
        if (lotto.contains(bonusNumber)){
            result.set(1, 1);
        }
        return result;
    }

    public static HashMap<Integer, List<Integer>> calculateCompareResult(int count, HashMap<Integer, List<Integer>> lotties, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < count; i++) {
            result.put(i, compare(lotties.get(i), winningNumbers, bonusNumber));
        }
        return result;
    }

    public static int prizeMoney(Rank rank){
        if (rank.equals(Rank.FIRST)){
            return 2000000000;
        }
        if (rank.equals(Rank.SECOND)){
            return 30000000;
        }
        if (rank.equals(Rank.THIRD)){
            return 1500000;
        }
        if (rank.equals(Rank.FOURTH)){
            return 50000;
        }
        if (rank.equals(Rank.FIFTH)){
            return 5000;
        }
        return 0;
    }
    public static Rank matchRank(int number) {
        if (number == 1) {
            return Rank.FIRST;
        }
        if (number == 2) {
            return Rank.SECOND;
        }
        if (number == 3) {
            return Rank.THIRD;
        }
        if (number == 4) {
            return Rank.FOURTH;
        }
        if (number == 5) {
            return Rank.FIFTH;
        }
        return Rank.OUT_OF_RANK;
    }
    public static HashMap<Integer, Integer> calculateRank(HashMap<Integer, List<Integer>> result, int count){
        HashMap<Integer, Integer> ranks = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            ranks.put(i, 0);
        }

        for (int i = 0; i < count; i++) {
            if (result.get(i).get(0) == 3){
                ranks.put(5, ranks.get(5) + 1);
            }
            if (result.get(i).get(0) == 4){
                ranks.put(4, ranks.get(4) + 1);
            }
            if (result.get(i).get(0) == 5){
                ranks.put(3, ranks.get(3) + 1);
            }
            if (result.get(i).get(0) == 5 && result.get(i).get(1) == 1){
                ranks.put(3, ranks.get(3) - 1);
                ranks.put(2, ranks.get(2) + 1);
            }
            if (result.get(i).get(0) == 6){
                ranks.put(1, ranks.get(1) + 1);
            }
        }
        return ranks;
    }


}
