package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

import java.util.List;

import lotto.view.ErrorMessage;
import lotto.view.Message;

public class BuyerLotto {
    public static int purchaseLottoCount;

    public static List<Lotto> purchaseLotto() {
        List<Lotto> lottoLists = new ArrayList<>();
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        String purchasePrice = readLine();
        purchaseLottoCount = Integer.parseInt(purchasePrice) / 1000;
        validateDivideNumber(purchasePrice);
        System.out.println(purchaseLottoCount + Message.PURCHASE_COUNT.getMessage());
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottoLists.add(Lotto.createLotto());
        }
        return lottoLists;
    }

    private static void validateDivideNumber(String purchasePrice) {
        if (Integer.parseInt(purchasePrice) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PRICE.getErrorMessage());
        }
    }
}
