package lotto.domain;

import java.util.List;

public class JudgeMent {
    private static final int initNumber = 0;
    private static final int correctNumberStandardWhenBonus = 5;

    public int compareNumbers(List<Integer> numbers, List<Integer> lottoNumbers) {
        int countCorrect = initNumber;
        for (int i = 0; i < Resource.numberSize; i++) {
            int number = numbers.get(i);
            if (lottoNumbers.contains(i)) {
                countCorrect++;
            }
        }
        return countCorrect;
    }

    public boolean bonusCheck(List<Integer> numbers, int correctCount, int bonusNumber) {
        if (correctCount == 5 && numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
