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
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / 1000;
    }

    private int validatePurchaseAmount(String input) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = stringToInteger(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 이루어져야 합니다.");
        }
        if (purchaseAmount % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 천원 단위여야 합니다.");
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
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = stringToIntegerList(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표와 숫자만 입력가능합니다.");
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리 숫자만 입력가능합니다. ");
        }
        if (Collections.min(winningNumbers) < 1 || Collections.max(winningNumbers) > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 범위 내에서 입력가능합니다.");
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
            throw new IllegalArgumentException();
        }
    }

    private int validateBonusNumber(String input) {
        int bonusNumber = 0;
        try {
            bonusNumber = stringToInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 숫자만 입력가능합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 중복되지 않는 수를 입력해 주세요.");
        }
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 범위 내에서 입력가능합니다. ");
        }
        return bonusNumber;
    }
}
