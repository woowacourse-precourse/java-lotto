package system.process;

import constants.LottoConstant;
import models.BoughtLottos;
import system.process.exception.IllegalArgument;
import utils.Input;
import utils.IsCollection;

public class Buying {

    private BoughtLottos boughtLottos;

    public Buying(String amountPaid) {
        boughtLottos = proceedBuying(amountPaid);
        boughtLottos.printLottoList();
    }

    private BoughtLottos proceedBuying(String amountPaid) {
        return buyLottos(calculateAvailableAmount(amountPaid));
    }

    int calculateAvailableAmount(String amountPaidInput) {
        int amountPaid = Integer.parseInt(amountPaidInput);

        if (amountPaid % LottoConstant.ONE_LOTTO_PRICE != 0) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIVISION.getMessage());
        }

        return amountPaid / LottoConstant.ONE_LOTTO_PRICE;
    }

    private BoughtLottos buyLottos(int amount) {
        return new BoughtLottos(amount);
    }

    public BoughtLottos getBuyingLottos() {
        return boughtLottos;
    }

}
