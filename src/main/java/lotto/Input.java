package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles all user input and associated exceptions.
 *
 * @author Davin An
 * @version 1.0
 */
public class Input {
    ExceptionHandler exception;

    public Input() {
        exception = new ExceptionHandler();
    }

    /**
     * Reads in user's purchase amount.
     *
     * @return Purchase amount as an integer
     */
    public int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        exception.purchaseAmountException(input);
        return Integer.parseInt(input);
    }

    /**
     * Reads in user's winning lotto numbers.
     *
     * @return Lotto numbers as a List
     */
    public List<Integer> winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().trim().split(",");
        List<String> stringList = Arrays.asList(input);
        exception.winningNumbersException(stringList);
        return stringList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * Reads in the lotto's bonus number.
     *
     * @return Bonus number as an integer
     */
    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        exception.bonusNumberException(Application.getWinningNum(), input);
        return Integer.parseInt(input);
    }
}
