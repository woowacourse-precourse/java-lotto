package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    public static int purchaseAmount() {
        try {
            int input = Integer.parseInt(input());
            checkLottoAmount(input);
            return input / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> winningNumber() {
        String input = input();
        return Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
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
