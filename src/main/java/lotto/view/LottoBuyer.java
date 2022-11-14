package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.ErrorMessage;
import lotto.domain.Lotto;

public class LottoBuyer {
    public static long purchaseAmount;
    private static final int LOTTO_PRICE = 1000;

    public static List<List<Integer>> purchaseLotto() {
        List<List<Integer>> lottos = new ArrayList<>();
        getPurchaseAmount();
        printLottos(lottos);
        return lottos;
    }

    private static void getPurchaseAmount() {
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        String inputPrice = readLine();
        validateInputPrice(inputPrice);
        validateDivideNumber(inputPrice);
        System.out.println();
        purchaseAmount = Integer.parseInt(inputPrice) / LOTTO_PRICE;
        System.out.println(purchaseAmount + Message.PURCHASE_COUNT.getMessage());
    }

    private static void printLottos(List<List<Integer>> lottos) {
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(Lotto.createLotto().getNumbers());
            System.out.println(lottos.get(i));
        }
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
