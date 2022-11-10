package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private List<Integer> winningNumbers;

    public WinningNumber() {
        String input = removeSpace(inputWinningNumbers());
        winningNumbers = Arrays.asList(input.split(",")).stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(winningNumbers);
    }

    private static String inputWinningNumbers() {
        return Console.readLine();
    }

    private String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }
}
