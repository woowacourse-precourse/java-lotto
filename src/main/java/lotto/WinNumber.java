package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumber {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_MAX_COUNT = 7;


    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinNumber(List<Integer> winNumbers, int bonusNumber) {
        validateSize(winNumbers);
        validateWinNumberRange(winNumbers);
        validateDuplicateNumber(winNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicateNumber(winNumbers, bonusNumber);

        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinNumberRange(List<Integer> numbers) {
        for (int judgeNumber : numbers) {
            if(judgeNumber > LOTTO_END_NUMBER && judgeNumber < LOTTO_START_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> duplicateFindNumber = new HashSet<>(numbers);
        if(numbers.size() != duplicateFindNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if(bonusNumber > LOTTO_END_NUMBER && bonusNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers, int bonusNumber) {
        numbers.add(bonusNumber);
        Set<Integer> duplicateFindNumber = new HashSet<>(numbers);
        if(numbers.size() != duplicateFindNumber.size()) {
            throw new IllegalArgumentException();
        }
    }


    public List<Integer> getLotteryWinNumber() {
        return winNumbers;
    }

    public int getLotteryBonusNumber() {
        return bonusNumber;
    }


}
