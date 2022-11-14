package lotto.ui;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static void printInputMessage() {
        System.out.println(INPUT_MONEY);
    }

    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    public static void printBuyMessage(int number) {
        System.out.println(number + BUY_MESSAGE);
    }

    public static void printLotto(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
        );
    }
}
