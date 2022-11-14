package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.model.ExceptionMessage;
import lotto.model.Lotto;

public class LottoMachine {

    private final static int LOTTO_PRICE = 1000;

    public static List<Lotto> generateLottos(String purchaseAmountStr) {
        int purchaseAmount = purchaseAmountStringToInteger(purchaseAmountStr);
        validatePurchaseAmount(purchaseAmount);
        return generateSortedLottos(purchaseAmount);
    }

    private static int purchaseAmountStringToInteger(String purchaseAmountStr) {
        try {
            return Integer.parseInt(purchaseAmountStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_INPUT.getExceptionMessage());
        }
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_PURCHASE_AMOUNT.getExceptionMessage());
        }
    }

    private static List<Lotto> generateSortedLottos(int purchaseAmount) {
        int amount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> newLottos = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = new ArrayList<>(LottoNumberGenerator.generateNumbers());
            Collections.sort(lottoNumbers);
            newLottos.add(new Lotto(lottoNumbers));
        }
        return newLottos;
    }

}
