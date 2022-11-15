package lotto.domain;

import static lotto.Input.PurchaseInput.inputPrice;

import java.util.ArrayList;
import java.util.List;
import lotto.Output.Message;

public class PurchaseLotto {
    public static int purchaseAmount;
    private static final int LOTTO_PRICE = 1000;
    public static List<List<Integer>> printPurchaseLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        getPurchaseAmount(inputPrice);
        printLottos(lottos);
        return lottos;
    }

    public static void getPurchaseAmount(String inputPrice) {
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
}
