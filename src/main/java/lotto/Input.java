package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static int purchaseAmount() {
        int parseInput = changeNumber(input());
        checkLottoAmount(parseInput);
        return parseInput / 1000;
    }

    public static List<Integer> winningNumber() {
        String input = input();
        checkContainSeparator(input);
        return Stream.of(input.split(","))
                .map(Input::changeNumber)
                .collect(Collectors.toList());
    }

    private static int changeNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static void checkContainSeparator(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 구분자 ',' 를 입력해 주세요.");
        }
    }

    private static void checkLottoAmount(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
    }

    private static String input() {
        return Console.readLine();
    }
}
