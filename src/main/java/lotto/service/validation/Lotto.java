package lotto.service.validation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Lotto {
    private final List<Integer> winningNumbers;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private static final String SEPARATOR = ",";

    public Lotto(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (!checkSize(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해야 합니다. 숫자 개수를 올바르게 입력해주세요.");
        }

        if (!assertEachNumberSatisfyRange(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (!hasUniqueNumbers(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.");
        }
    }





    private boolean checkSize(List<Integer> winningNumbers) {
        return winningNumbers.size() == WINNING_NUMBERS_SIZE;
    }

    private boolean assertEachNumberSatisfyRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().allMatch(this::isRightRange);
    }

    private boolean hasUniqueNumbers(List<Integer> winningNumbers) {
        final Set<Integer> uniques = new HashSet<>();
        for(Integer number: winningNumbers) {
            if(!uniques.add(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightRange(int bonus) {
        return bonus <= MAX_LOTTO_NUMBER && bonus >= MIN_LOTTO_NUMBER;
    }

    private boolean includesWinningNumbers(int number) {
        return !winningNumbers.contains(number);
    }
}