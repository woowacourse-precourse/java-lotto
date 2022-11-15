package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputScanner {
    private List<Integer> winningNumbers;

    public int scanPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = 0;
        try {
            purchaseAmount = validatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return purchaseAmount / 1000;
    }

    private int validatePurchaseAmount(String input) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = stringToInteger(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_NUMBER_FORMAT.getMessage());
        }
        if (purchaseAmount % 1000 > 0) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_MONETARY_UNIT.getMessage());
        }
        return purchaseAmount;
    }

    private int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public List<Integer> scanWinningNumbers() {
        List<Integer> _winningNumbers;
        String input = Console.readLine();
        try {
            _winningNumbers = validateWinningNumbers(input);
            winningNumbers = _winningNumbers;
            return sortWinningNumbers(_winningNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = stringToIntegerList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_WINNING_NUMBER_FORMAT.getMessage());
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_WINNING_NUMBER_SIZE.getMessage());
        }
        if (Collections.min(winningNumbers) < 1 || Collections.max(winningNumbers) > 45) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_NUMBER_RANGE.getMessage());
        }
        return winningNumbers;
    }

    private List<Integer> sortWinningNumbers(List<Integer> inputNumbers) {
        Collections.sort(inputNumbers);
        return inputNumbers;
    }

    private List<Integer> stringToIntegerList(String input) {
        List<Integer> conversionResult;
        try {
            conversionResult = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return conversionResult;
    }

    public int scanBonusNumber() {
        String input = Console.readLine();
        int bonusNumber = 0;
        try {
            bonusNumber = validateBonusNumber(input);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private int validateBonusNumber(String input) {
        int bonusNumber = 0;
        try {
            bonusNumber = stringToInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_NUMBER_FORMAT.getMessage());
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_NUMBER_OVERLAP.getMessage());
        }
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(Messages.ERROR_PREFIX.getMessage() + Messages.ERROR_NUMBER_RANGE.getMessage());
        }
        return bonusNumber;
    }
}
