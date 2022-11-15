package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String ERROR_NO_POSITIVE_INTEGER = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_NO_LOTTO_NUMBER = "[ERROR] 정수 1 ~ 45를 입력해주세요.";
    private static final String ERROR_WRONG_LOTTO_SIZE = "[ERROR] 당첨 번호 6개를 입력해주세요.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.";

    private final List<Integer> winningNumbers;
    private int bonusBall;

    public WinningLotto(List<String> numbers) {
        validateWinningNumbers(numbers);
        winningNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void pickBonusBall(String bonusBall) {
        validateBonusBall(bonusBall);
        this.bonusBall = Integer.parseInt(bonusBall);
    }

    private void validateBonusBall(String bonusBall) {
        try {
            int bonusBallNumber = Integer.parseInt(bonusBall);
            checkLottoNumber(bonusBallNumber);
            checkDuplicate(winningNumbers, bonusBallNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NO_POSITIVE_INTEGER);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validateWinningNumbers(List<String> numbers) {
        Set<Integer> unDuplicateNumbers = new HashSet<>();
        try {
            for (String number : numbers) {
                int lottoNumber = Integer.parseInt(number);
                checkLottoNumber(lottoNumber);
                unDuplicateNumbers.add(lottoNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NO_POSITIVE_INTEGER);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        checkLottoNumberSize(unDuplicateNumbers);
    }

    private void checkLottoNumberSize(Set<Integer> unDuplicateNumbers) {
        if (unDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_SIZE);
        }
    }

    private void checkDuplicate(List<Integer> numbers, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    private void checkLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_NO_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
