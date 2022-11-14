package lotto.domain.impl;

import lotto.domain.Judgment;

import java.util.List;

public class JudgmentImpl implements Judgment {

    @Override
    public int correctCount(List<Integer> userNumbers, List<Integer> priceNumber) {
        int count = 0;

        for (Integer userNumber : userNumbers) {
            if (priceNumber.contains(userNumber)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        return false;
    }
}
