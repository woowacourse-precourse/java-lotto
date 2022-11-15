package lotto.domain;

import java.util.*;

public class WinLotto {
    private final List<Integer> winNumbers;
    private final Integer bonusNumber;

    public WinLotto(String winNumbers, String bonusNumber) {
        validateDigitWinNumbers(winNumbers);
        validateCountWinNumbers(convertString2ListInteger(winNumbers));
        validateInRangedWinNumbers(convertString2ListInteger(winNumbers));
        validateDuplicatedWinNumbers(convertString2ListInteger(winNumbers));
        this.winNumbers = convertString2ListInteger(winNumbers);

        validateDigitBonusNumbers(bonusNumber);
        validateInRangedBonusNumbers(Integer.parseInt(bonusNumber));
        validateDuplicatedBonusNumbers(Integer.parseInt(bonusNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateDigitWinNumbers(String winNumbers) {
        String normalizedWinNumbers = winNumbers.replaceAll(",", "");
        for (int index = 0; index < normalizedWinNumbers.length(); index++) {
            if (!Character.isDigit(normalizedWinNumbers.charAt(index))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }

    private List<Integer> convertString2ListInteger(String winNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : winNumbers.split(",")) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void validateCountWinNumbers(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
    }

    private void validateInRangedWinNumbers(List<Integer> winNumbers) {
        for (Integer number : winNumbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicatedWinNumbers(List<Integer> winNumbers) {
        Set<Integer> hashSet = new HashSet<>(winNumbers);
        if (hashSet.size() != winNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    private void validateDigitBonusNumbers(String bonusNumber) {
        if (!Character.isDigit(bonusNumber.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateInRangedBonusNumbers(Integer bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicatedBonusNumbers(Integer bonusNumber) {
        if (this.winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinNumbers() {
        return this.winNumbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
