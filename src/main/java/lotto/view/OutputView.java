package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String UNIT = "개";
    private static final String MESSAGE_BUY_SUFFIX = "를 구매했습니다.";

    public static void printLotteryCount(Integer count) {
        System.out.println(count.toString() + UNIT + MESSAGE_BUY_SUFFIX);
    }

    public static void printString(String input) {
        System.out.println(input);
    }

    public static void printCreatedNumbers(List<Integer> numbers) {
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

}
