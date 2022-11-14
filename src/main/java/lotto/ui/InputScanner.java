package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputScanner {
    private List<Integer> winningNumbers;

    public int scanPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = 0;
        purchaseAmount = stringToInteger(input);
        return purchaseAmount / 1000;
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
        _winningNumbers = stringToIntegerList(input);
        sortWinningNumbers(_winningNumbers);
        winningNumbers = _winningNumbers;
        return sortWinningNumbers(_winningNumbers);
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
        bonusNumber = stringToInteger(input);
        return bonusNumber;
    }
}
