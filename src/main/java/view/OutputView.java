package view;

import lotto.domain.PurchasedLottos;

import java.util.Arrays;

import static lotto.constant.Message.ERROR_MESSAGE;
import static lotto.constant.Message.PURCHASE_LOTTO_MESSAGE;

public class OutputView {
    public void getErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public void printPurchasedLottos(int count, PurchasedLottos purchasedLottos) {
        System.out.println(count + PURCHASE_LOTTO_MESSAGE);

        purchasedLottos.getPurchasedLottos()
                .forEach(purchasedLotto -> {
                    System.out.println(
                            Arrays.toString(
                                    purchasedLotto
                                            .getNumbers()
                                            .stream()
                                            .toArray()
                            )
                    );
                });
    }
}
