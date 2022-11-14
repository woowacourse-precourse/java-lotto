package system.process;

import constants.LottoConstant;
import models.BoughtLottos;
import system.process.validation.BuyingValidation;
import utils.Input;
import veiw.BuyingView;

public class Buying {
    private BoughtLottos boughtLottos;

    public Buying() {
        boughtLottos =  proceedBuying(inputAmountPaid());
        BuyingView.printLottoList(boughtLottos.getLottos());
    }

    private BoughtLottos proceedBuying(String amountPaid) {
        return new BoughtLottos(calculateAvailableAmount(amountPaid));
    }

    private String inputAmountPaid() {
        BuyingView.printInputAmountPaidText();
        String amountPaidInput = Input.input();

        BuyingValidation.validateAmountPaidInput(amountPaidInput);

        return amountPaidInput;
    }


    private int calculateAvailableAmount(String amountPaidInput) {
        int amountPaid = Integer.parseInt(amountPaidInput);
        BuyingValidation.validateAvailableAmount(amountPaid);

        return amountPaid / LottoConstant.LOTTO_PRICE;
    }

    public BoughtLottos getBoughtLottos() {
        return boughtLottos;
    }
}
