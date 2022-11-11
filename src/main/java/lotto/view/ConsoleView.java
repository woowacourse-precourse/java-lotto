package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.message.ConsoleMessage;
import lotto.validator.InputValidator;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView {
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    public static void printBlankLine() {
        System.out.println();
    }

    public static int inputPurchasePrice() {
        System.out.println(ConsoleMessage.INPUT_PURCHASE_PRICE.getMessage());
        String input = Console.readLine();
        return InputValidator.changeStringToInt(input);
    }

    public static void printPurchaseAmount(int amount) {
        String message = amount + ConsoleMessage.OUTPUT_PURCHASE_AMOUNT.getMessage();
        System.out.println(message);
    }

    public static void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto: lottos) {
            System.out.print(LEFT_BRACKET);
            printLottoNumbers(lotto);
            System.out.println(RIGHT_BRACKET);
        }
    }

    private static void printLottoNumbers(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.print(numbers);
    }
}
