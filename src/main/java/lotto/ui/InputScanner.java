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
}
