package system.process;

import constants.LottoConstant;
import models.BoughtLottos;
import system.process.validation.BuyingValidation;
import view.BuyingView;

public class Buying {
    private BoughtLottos boughtLottos;

    public Buying() {
        boughtLottos =  proceedBuying(BuyingView.inputBoughtLottos());
        BuyingView.printLottoList(boughtLottos.getLottos());
    }

    private BoughtLottos proceedBuying(int amountPaid) {
        return new BoughtLottos(calculateAvailableAmount(amountPaid));
    }

    private int calculateAvailableAmount(int amountPaid) {
        BuyingValidation.validateAvailableAmount(amountPaid);

        return amountPaid / LottoConstant.LOTTO_PRICE;
    }

    public BoughtLottos getBoughtLottos() {
        return boughtLottos;
    }
}
