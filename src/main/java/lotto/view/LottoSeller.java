package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.resource.ErrorType;
import lotto.resource.MessageType;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {
    private static final String ONLY_NUMERIC = "^[0-9]*$";
    private static final String SEPARATOR = ",";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(MessageType type) {
        System.out.println(type.getMessage());
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        int lottoPurchaseCount = lottoTickets.size();
        printMessage(String.format(
                MessageType.PURCHASE_COMPLETION.getMessage(), lottoPurchaseCount));

        for (int i = 0; i < lottoPurchaseCount; i++) {
            printMessage(lottoTickets.get(i).toString());
        }
    }

    public static int receivePurchasePrice() {
        printMessage(MessageType.PURCHASE_PRICE);
        try {
            return receiveNumber();
        } catch (Exception e) {
            return receiveNumber();
        }
    }

    public static List<Integer> receiveWinningNumbers() {
        printMessage(MessageType.WINNING_NUMBER);
        String userInput = Console.readLine();
        try {
            validateWinningNumbers(userInput);
        } catch (Exception e) {
            return receiveWinningNumbers();
        }
        List<String> winningNumbers = Arrays.asList(userInput.split(SEPARATOR));

        return winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int receiveBonusNumber() {
        printMessage(MessageType.BONUS_NUMBER);
        try {
            return receiveNumber();
        } catch (Exception e) {
            return receiveNumber();
        }
    }

    private static void validateWinningNumbers(String input) {
        String[] numbers = input.split(SEPARATOR, 0);

        for (int i = 0; i < numbers.length; i++) {
            validateNumber(numbers[i]);
        }
    }

    private static void validateNumber(String input) {
        if (!input.matches(ONLY_NUMERIC))
            Error.printException(ErrorType.NOT_NUMBER);
    }

    private static int receiveNumber() {
        String userInput = Console.readLine();

        validateNumber(userInput);

        return Integer.parseInt(userInput);
    }
}
