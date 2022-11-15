package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.output.ErrorMessage;
import lotto.output.Message;

public class PurchaseInput {
    private static final int LOTTO_PRICE = 1000;
    public static String inputPrice;

    public static void inputPurchasePrice() {
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        inputPrice = readLine();
        validateInputPrice(inputPrice);
        validateDivideNumber(inputPrice);
        System.out.println();
    }

    private static void validateDivideNumber(String inputPrice) {
        if (Integer.parseInt(inputPrice) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PRICE_THOUSAND_UNITS.getErrorMessage());
        }
    }

    private static void validateInputPrice(String inputPrice) {
        char[] charInputPrice = inputPrice.toCharArray();
        for (char character : charInputPrice) {
            if (character < '0' || character > '9') {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_PRICE.getErrorMessage());
            }
        }
    }
}
