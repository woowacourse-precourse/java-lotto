package system.process;

import constants.LottoConstant;
import models.BoughtLottos;
import system.process.exception.IllegalArgument;
import utils.Input;

public class Buying {

    private BoughtLottos boughtLottos;

    public Buying() {
        boughtLottos = proceedBuying(inputAmountPaid());
        boughtLottos.printLottoList();
    }

    private BoughtLottos proceedBuying(String amountPaid) {
        return new BoughtLottos(calculateAvailableAmount(amountPaid));
    }

    private String inputAmountPaid() {
        printInputAmountPaidText();
        String amountPaidInput = Input.input();

        if (amountPaidInput.contains(",")) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_TEXT.getMessage());
        }

        if(amountPaidInput.length() > LottoConstant.MAX_LOTTO_PRICE_LENGTH){
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }

        return amountPaidInput;
    }

    int calculateAvailableAmount(String amountPaidInput) {
        int amountPaid = Integer.parseInt(amountPaidInput);

        if(amountPaid > LottoConstant.MAX_LOTTO_PRICE){
            IllegalArgument.handleException(IllegalArgument.OUT_OF_AMOUNT_PAID.getMessage());
        }

        if (amountPaid % LottoConstant.LOTTO_PRICE != 0) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIVISION.getMessage());

        }
        return amountPaid / LottoConstant.LOTTO_PRICE;
    }

    public BoughtLottos getBoughtLottos() {
        return boughtLottos;
    }

    public static void printInputAmountPaidText() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

}
