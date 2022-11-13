package lotto.verifiable;

import lotto.Prize;
import lotto.Profit;

import java.util.*;

public class CheckPrize implements Verifiable<Prize>{
    @Override
    public Integer checkWithValue(Profit input) {
        return null;
    }

    @Override
    public Integer checkWithValue(Prize input) {
        List<Integer> numbersWithBonus = input.getNumberWithBonusNumber();
        List<Integer> purchaseNumber = input.getNumber();
        int cnt = 0;
        for (Integer number : numbersWithBonus) {
            if(Collections.frequency(purchaseNumber, number)>0){
                cnt++;
            }
        }
        return cnt;
    }

    public Map<PrizeMoney, Integer> checkPrizes(List<List<Integer>> numbers, List<Integer> prizeNumber, Integer bonusNumber){
        Verifiable<Prize> check = new CheckPrize();
        Map<PrizeMoney, Integer> gradeCount = new EnumMap<>(PrizeMoney.class);
        initialMap(gradeCount);

        List<Integer> bonus = new ArrayList<>();
        bonus.add(bonusNumber);

        for (List<Integer> number : numbers) {
            Integer prizeCount = check.checkWithValue(new Prize(number, prizeNumber));
            Integer bonusCount = check.checkWithValue(new Prize(number, bonus));
            recordGrade(prizeCount, gradeCount, bonusCount);
        }
        return gradeCount;
    }

    private Map<PrizeMoney, Integer> recordGrade(Integer prizeCount, Map<PrizeMoney, Integer> gradeCount, Integer bonusCount) {
        if(prizeCount.equals(6)) {
            Integer integer = gradeCount.get(PrizeMoney.FIRST);
            gradeCount.put(PrizeMoney.FIRST, integer+1);
        } else if(prizeCount.equals(5) && bonusCount.equals(1)){
            Integer integer = gradeCount.get(PrizeMoney.SECOND);
            gradeCount.put(PrizeMoney.SECOND, integer+1);
        } else if (prizeCount.equals(5)) {
            Integer integer = gradeCount.get(PrizeMoney.THIRD);
            gradeCount.put(PrizeMoney.THIRD, integer+1);
        } else if (prizeCount.equals(4)) {
            Integer integer = gradeCount.get(PrizeMoney.FOUR);
            gradeCount.put(PrizeMoney.FOUR, integer+1);
        } else if (prizeCount.equals(3)) {
            Integer integer = gradeCount.get(PrizeMoney.FIVE);
            gradeCount.put(PrizeMoney.FIVE, integer+1);
        }
        return gradeCount;
    }

    private void initialMap(Map<PrizeMoney, Integer> gradeCount) {
        PrizeMoney[] rankings = PrizeMoney.values();
        for (PrizeMoney ranking : rankings) {
            gradeCount.put(ranking, 0);
        }
    }
}