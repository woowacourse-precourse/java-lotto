package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Input {
    private static final int LOTTO_SIZE = 6;
    private static final int BONUS_NUMBER = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getAmount() {
        try {
            String amount = Console.readLine();
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER_MESSAGE);
        try {
            List<Integer> winningNumber = stringToList(Console.readLine());

            return winningNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] Only enter numbers.");
        }
    }

    private static List<Integer> stringToList(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(toList());
    }


}
