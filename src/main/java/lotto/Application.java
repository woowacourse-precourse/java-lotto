package lotto;

import lotto.model.LottoNumberGenerator;
import lotto.model.LottoSeller;
import lotto.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void run() {
        PurchasePrice purchasePrice = new PurchasePrice(InputView.purchasePrice());
        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());
        OutputView.printQuantity(lottoSeller.calculateQuantity(purchasePrice));
    }
}
