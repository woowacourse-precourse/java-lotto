package lotto.application.input.purchasemoney;

import lotto.application.output.inputguideprinter.InputGuidePrinter;
import lotto.application.util.inputagent.InputAgent;

public class PurchaseMoneyInputImpl implements PurchaseMoneyInput {

    private final InputAgent inputAgent;
    private final InputGuidePrinter inputGuidePrinter;

    public PurchaseMoneyInputImpl(InputAgent inputAgent, InputGuidePrinter inputGuidePrinter) {
        this.inputAgent = inputAgent;
        this.inputGuidePrinter = inputGuidePrinter;
    }

    @Override
    public int inputPurchaseMoney() {
        inputGuidePrinter.inputPurchaseMoneyGuide();
        int inputValue = 0;
        try {
            inputValue = inputAgent.inputUserPurchaseMoney();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }

        inputGuidePrinter.finalPurchaseLottoCountGuide(inputValue);
        return inputValue;
    }
}
