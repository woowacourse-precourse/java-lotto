package lotto.domain.impl;

import lotto.domain.Judgment;

import java.util.List;

public class JudgmentImpl implements Judgment {

    @Override
    public int correctCount(List<Integer> userNumbers, List<Integer> prizeNumber) {
        return (int) userNumbers.stream()
                .filter(prizeNumber::contains)
                .count();
    }

    @Override
    public boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber) {
        for (int userNumber : userNumbers) {
            if (isNumberEq(userNumber, bonusNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberEq(int number1, int number2) {
        return number1 == number2;
    }
}
