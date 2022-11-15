package lotto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumber {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;


    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinNumber(List<Integer> winNumbers, int bonusNumber) {
        validateSize(winNumbers);
        validateWinNumberRange(winNumbers);
        validateDuplicateNumber(winNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonusNumber(winNumbers, bonusNumber);

        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int judgeNumber : numbers) {
            if(judgeNumber > LOTTO_END_NUMBER && judgeNumber < LOTTO_START_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 숫자 범위에 없습니다");
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicateFindNumber = new HashSet<>(numbers);
        if(numbers.size() != duplicateFindNumber.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 다릅니다.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) throws IllegalArgumentException {
        if(bonusNumber > LOTTO_END_NUMBER && bonusNumber < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위에 없습니다");
        }
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자 개수가 다릅니다.");
        }
    }


    public List<Integer> getLotteryWinNumber() {
        return winNumbers;
    }

    public int getLotteryBonusNumber() {
        return bonusNumber;
    }


}
