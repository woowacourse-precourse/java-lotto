package lotto.verifiable;

import lotto.Grade;
import lotto.Prize;

import java.util.*;

public class CheckPrize implements Verifiable<Prize>{
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

    public Map<Grade, Integer> checkPrizes(List<List<Integer>> numbers, List<Integer> prizeNumber, Integer bonusNumber){
        Verifiable<Prize> check = new CheckPrize();
        Map<Grade, Integer> gradeCount = new EnumMap<>(Grade.class);
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

    private Map<Grade, Integer> recordGrade(Integer prizeCount, Map<Grade, Integer> gradeCount, Integer bonusCount) {
        if(prizeCount.equals(6)) {
            Integer integer = gradeCount.get(Grade.FIRST);
            gradeCount.put(Grade.FIRST, integer+1);
        } else if(prizeCount.equals(5) && bonusCount.equals(1)){
            Integer integer = gradeCount.get(Grade.SECOND);
            gradeCount.put(Grade.SECOND, integer+1);
        } else if (prizeCount.equals(5)) {
            Integer integer = gradeCount.get(Grade.THIRD);
            gradeCount.put(Grade.THIRD, integer+1);
        } else if (prizeCount.equals(4)) {
            Integer integer = gradeCount.get(Grade.FOUR);
            gradeCount.put(Grade.FOUR, integer+1);
        } else if (prizeCount.equals(3)) {
            Integer integer = gradeCount.get(Grade.FIVE);
            gradeCount.put(Grade.FIVE, integer+1);
        }
        return gradeCount;
    }

    private void initialMap(Map<Grade, Integer> gradeCount) {
        Grade[] rankings = Grade.values();
        for (Grade ranking : rankings) {
            gradeCount.put(ranking, 0);
        }
    }

}