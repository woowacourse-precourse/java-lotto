package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;

import lotto.view.ErrorMessage;
import lotto.view.Message;

public class BuyerLotto {
    public void purchaseLotto() {
        System.out.println(Message.PURCHASE_PRICE.getMessage());
        String purchasePrice = readLine();
        int purchaseLottoCount = Integer.parseInt(purchasePrice) / 1000;
        validateDivideNumber(purchasePrice);
        System.out.println(purchaseLottoCount + Message.PURCHASE_COUNT.getMessage());
        printLottos(purchaseLottoCount);
    }

    public void printLottos(int purchaseLottoCount) {
        for (int i = 0; i < purchaseLottoCount; i++) {
            Lotto lotto = new Lotto(new ArrayList<>());
            lotto.createLottoNumber();
        }
    }

    private void validateDivideNumber(String purchasePrice) {
        if (Integer.parseInt(purchasePrice) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PRICE.getErrorMessage());
        }
    }
}
