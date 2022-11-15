package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.enums.BuyerPrint;
import lotto.domain.enums.PurchaseAmountUnit;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final List<Lotto> purchaseLotto = new ArrayList<>();
    private int lottoAmount;

    Buyer(int lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    static void validConsistByNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static int LottoAmountConversion(String inputValue) {
        int purchaseAmount;
        PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;

        validConsistByNumber(inputValue);
        purchaseAmount = Integer.parseInt(inputValue);
        purchaseAmountUnit.validDivisionByThousand(purchaseAmount);

        return purchaseAmount;
    }

    public void buyLotto() {
        PurchaseAmountUnit purchaseAmountUnit = PurchaseAmountUnit.LOTTO_PURCHASE_UNIT;
        int lottoCount = purchaseAmountUnit.purchaseAmount(lottoAmount);

        while (purchaseLotto.size() < lottoCount) {
            purchaseLotto.add(Lotto.creatLottoNumbers(lottoCount));
        }
    }
}
