package system.process;

import constants.LottoConstant;
import models.BoughtLottos;
import system.process.exception.IllegalArgument;
import utils.Input;
import utils.IsCollection;

public class Buying {

    private BoughtLottos boughtLottos;

    public Buying() {
        boughtLottos = proceedBuying();
        printboughtLottos();
    }

    private BoughtLottos proceedBuying() {
        String amountPaidInput = inputAmountPaid();
        int amount = calculateAvailableAmount(amountPaidInput);
        return buyLottos(amount);
    }

    String inputAmountPaid() throws IllegalArgumentException {
        printInputAmountPaidText();
        String amountPaidInput = Input.input();

        if (IsCollection.isContain(amountPaidInput, ",")) {
            IllegalArgument.handleException(IllegalArgument.NOT_DIGIT_TEXT.getMessage());
        }

        return amountPaidInput;
    }

    int calculateAvailableAmount(String amountPaidInput) throws IllegalArgumentException {
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

    private void printboughtLottos() {
        boughtLottos.printLottoList();
    }

    private void printInputAmountPaidText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

}
