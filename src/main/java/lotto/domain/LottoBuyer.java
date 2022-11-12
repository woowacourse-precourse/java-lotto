package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

import lotto.view.ErrorMessage;
import lotto.view.Message;

public class LottoBuyer {
    public static int purchaseLottoCount;

    public static List<List<Integer>> purchaseLotto() {
        List<List<Integer>> lottos = new ArrayList<>();
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        String purchasePrice = readLine();
        System.out.println();
        purchaseLottoCount = Integer.parseInt(purchasePrice) / 1000;
        validateDivideNumber(purchasePrice);
        System.out.println(purchaseLottoCount + Message.PURCHASE_COUNT.getMessage());
        printLottos(lottos);
        return lottos;
    }

    private static void printLottos(List<List<Integer>> lottos) {
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(Lotto.createLotto().getNumbers());
            System.out.println(lottos.get(i));
        }
        System.out.println();
    }

    private static void validateDivideNumber(String purchasePrice) {
        if (Integer.parseInt(purchasePrice) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PRICE.getErrorMessage());
        }
    }
}
