package lotto.valid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputLottoValidator {

    private static final int WINNING_NUMBER_COUNT = 6;

    public void validateMoney(String money) {
        isDigit(money);
        isThousandUnitMoney(money);
    }

    private void isDigit(String inputValue) {

        for (int i = 0; i < inputValue.length(); i++) {
            if (!Character.isDigit(inputValue.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하여야 합니다.");
            }
        }
    }

    private void isThousandUnitMoney(String money) {
        int integerMoney = Integer.parseInt(money);

        if (integerMoney == 0 || integerMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈을 입력하여야 합니다.");
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        isDistinguishComma(winningNumbers);
        isDigit(winningNumbers.replace(",", ""));
        checkCountWinningNumbers(winningNumbers);
        checkRangeWinningNumbers(winningNumbers);
        duplicateWinningNumbers(winningNumbers);
    }

    private void isDistinguishComma(String winningNumbers) {
        if (winningNumbers.length() - winningNumbers.replace(",", "").length()
            != WINNING_NUMBER_COUNT - 1) {
            throw new IllegalArgumentException("[ERROR] 번호는 쉼표를 기준으로 구분하여야 합니다.");
        }
    }

    private void checkCountWinningNumbers(String winningNumbers) {
        if (winningNumbers.split(",").length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호들을 입력하여야 합니다.");
        }
    }

    private void checkRangeWinningNumbers(String winningNumbers) {
        List<Integer> distinguishWinningNumbers = Arrays.asList(winningNumbers.split(",")).stream()
            .map(s -> Integer.parseInt(s)).collect(
                Collectors.toList());
        if (!distinguishWinningNumbers.stream().allMatch(v -> v >= 1 && v <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void duplicateWinningNumbers(String winningNumbers) {
        List<String> distinguishWinningNumbers = Arrays.asList(winningNumbers.split(","));
        Set<String> deduplicationWinningNumbers = new HashSet<>(distinguishWinningNumbers);

        if (distinguishWinningNumbers.size() != deduplicationWinningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 번호들을 입력하여야 합니다.");
        }
    }

    public void validateBonusNumber(String bonusNumber, String winningNumbers) {
        isDigit(bonusNumber);
        checkCountBonusNumber(bonusNumber);
        duplicateBonusNumber(bonusNumber, winningNumbers);
        checkRangeBonusNumber(bonusNumber);
    }

    public void checkCountBonusNumber(String bonusNumber) {
        if (bonusNumber.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 1개의 번호를 입력하여야 합니다.");
        }
    }

    private void duplicateBonusNumber(String bonusNumber, String winningNumbers) {
        if (Arrays.stream(winningNumbers.split(",")).anyMatch(v -> v.equals(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 다른 번호를 입력하여야 합니다.");
        }
    }

    private void checkRangeBonusNumber(String bonusNumber) {
        int integerBonusNumber = Integer.parseInt(bonusNumber);
        if (!(integerBonusNumber >= 1 && integerBonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 번호를 입력하여야 합니다.");
        }
    }

}
