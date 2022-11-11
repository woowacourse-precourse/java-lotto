package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String SEPARATOR = ",";

    public static int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();

        return Integer.parseInt(money);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbersWithSeparator = Console.readLine();

        return getWinningNumbers(numbersWithSeparator);
    }

    private static List<Integer> getWinningNumbers(String numbersWithSeparator) {
        String[] winningNumbers = numbersWithSeparator.split(SEPARATOR);
        return Arrays.stream(winningNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
