package lotto.domain;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JudgeMent {
    private static final int initNumber = 0;
    private static final int correctNumberStandardWhenBonus = 5;
    private static final int minCorrectNumber =3;
    private Map<Reward,Integer> correctResult= new HashMap<>();

    public int compareNumbers(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int countCorrect = initNumber;
        for (int i = 0; i < Resource.numberSize; i++) {
            int number = winningNumbers.get(i);
            if (lottoNumbers.contains(i)) {
                countCorrect++;
            }
        }
        return countCorrect;
    }

    public boolean bonusCheck(List<Integer> numbers,int bonusNumber) {
        if (numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
    private Reward getReward(List<Integer> numbers, WinningNumber winningNumber) {
        int correctCount = compareNumbers(winningNumber.getNumbers(), numbers);
        if (correctCount >= minCorrectNumber) {
            return checkReward(numbers, winningNumber, correctCount);
        }
        return Reward.NOTHING;
    }

    private Reward checkReward(List<Integer> numbers, WinningNumber winningNumber, int correctCount) {
        if(minCorrectNumber == Reward.THREE.getNumber()){
            return Reward.THREE;
        }
        if(minCorrectNumber==Reward.FOUR.getNumber()){
            return Reward.FOUR;
        }
        if(minCorrectNumber==Reward.FIVE.getNumber()){
            if (bonusCheck(numbers, winningNumber.getBonusNumber())) {
                return Reward.FIVE_BONUS;
            }
            return Reward.FIVE;
        }
        return Reward.SIX;
    }
}
