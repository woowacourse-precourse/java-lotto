package system.process;

import models.PurchasedLottosData;

public class Purchase {

    private PurchasedLottosData purchasedLottos;
    public Purchase(){
        purchasedLottos = proceedPurchase();
        printPurchasedLottoList();
    }

    private void proceedPurchase(){

        printAmountPaidText();

        int amount = calculateAvailableAmount(inputAmountPaid());
        return purchaseLottos(amount);

    }

}
