package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int winningBonusNumber;


    private static int START_LOTTO_NUMBER = 1;
    private static int END_LOTTO_NUMBER = 45;
    private static int LOTTO_NUMBER_COUNT = 6;
    private static String SPLIT_DELIMITER = ",";

    public WinningNumbers(String numbers, String bonusNumber) {
        validateWinningNumbersContainsComma(numbers);
        addWinningNumbers(numbers);
        validateIsContainsOverlappedNumber(winningNumbers);
        addBonusNumber(bonusNumber);
        validateIsNotNumbersOverlapped(winningNumbers, winningBonusNumber);
        validateIsNumbersIncludedOneToFortyFive(winningNumbers, winningBonusNumber);
        validateSize(winningNumbers);
    }

    private void validateWinningNumbersContainsComma(String numbers) {
        if (!numbers.contains(",")) {
            throw new IllegalArgumentException("번호는 콤마(,)로 구분돼야 합니다.");
        }
    }

    private void validateIsContainsOverlappedNumber(List<Integer> winningNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력이 불가능합니다.");
        }
    }

    private void addWinningNumbers(String numbers) {
        String[] winningNumbers = numbers.split(SPLIT_DELIMITER);
        for (String winningNumber : winningNumbers) {
            try {
                this.winningNumbers.add(Integer.parseInt(winningNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    private void addBonusNumber(String bonusNumber) {
        try {
            this.winningBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateIsNotNumbersOverlapped(List<Integer> winningNumbers, int winningBonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == winningBonusNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 당첨 보너스 번호는 중복될 수 없습니다.");
            }
        }
    }

    private void validateIsNumbersIncludedOneToFortyFive(List<Integer> winningNumbers, int winningBonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < START_LOTTO_NUMBER || winningNumber > END_LOTTO_NUMBER) {
                throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %s에서 %s사이의 숫자여야 합니다.", START_LOTTO_NUMBER, END_LOTTO_NUMBER));
            }
        }
        if (winningBonusNumber < START_LOTTO_NUMBER || winningBonusNumber > END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 보너스 번호는 %s에서 %s사이의 숫자여야 합니다.", START_LOTTO_NUMBER, END_LOTTO_NUMBER));
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] %s개의 숫자를 입력해주세요.", LOTTO_NUMBER_COUNT));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonusNumber() {
        return winningBonusNumber;
    }
}
