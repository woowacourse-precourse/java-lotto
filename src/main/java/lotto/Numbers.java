package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Numbers(List<Integer> winningNumbers, int bonusNumber) {
        validateForWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;

        validateRange(bonusNumber);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> numbers = winningNumbers.stream().collect(Collectors.toList());
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateForWinningNumbers(List<Integer> winningNumbers){
        validateSize(winningNumbers);
        winningNumbers.stream().forEach(number -> validateRange(number));
        validateDuplicate(winningNumbers);
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자가 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
        if (nonDuplicateNumbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.");
    }

    private void validateRange(int number) {
        if (number < 0 || number > 45)
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        if(!winningNumbers.stream().allMatch(number -> number != bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }
}
