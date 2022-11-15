package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessages;

public class InputView {

    private InputView() {
    }

    public static long askAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseLong(input);
    }

    public static List<Integer> askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseIntegerList(input);
    }

    public static int askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.INPUT);
            throw new IllegalArgumentException();
        }
    }

    private static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.INPUT);
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseIntegerList(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : numbers) {
            try {
                winningNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessages.INPUT);
                throw new IllegalArgumentException();
            }
        }
        return winningNumbers;
    }
}
