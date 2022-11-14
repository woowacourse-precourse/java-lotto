package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.utils.Validator;

public class InputView {

    public static int getPurchaseAmount() {
        String input = askPurchaseAmount();
        validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    private static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private static void validatePurchaseAmount(String input) {
        Validator.isBlank(input);
        Validator.isNumber(input);
    }

    public static List<Integer> createWinningNumbers() {
        String input = askWinningNumbers();
        validateWinningNumbers(input);
        return inputStringToList(input);
    }

    private static String askWinningNumbers() throws IllegalArgumentException {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private static void validateWinningNumbers(String input) {
        Validator.isCommaCorrect(input);
        Validator.isAllNumber(input);
    }

    private static List<Integer> inputStringToList(String input) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            winningNumbers.add(Integer.valueOf(number));
        }
        return winningNumbers;
    }

    public static String askBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }
}
