package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessenger {
    private final OutputMessenger outputMessenger;

    private InputMessenger(OutputMessenger outputMessenger) {
        this.outputMessenger = outputMessenger;
    }

    public static InputMessenger using(OutputMessenger outputMessenger) {
        return new InputMessenger(outputMessenger);
    }

    private String receiveUserInput() {
        return Console.readLine();
    }

    public String receivePayment() {
        outputMessenger.printPaymentInputMessage();
        return receiveUserInput();
    }

    public String receiveWinningNumbers() {
        outputMessenger.printWinningNumberInputMessage();
        return receiveUserInput();
    }

    public String receiveBonusNumber() {
        outputMessenger.printBonusNumberInputMessage();
        return receiveUserInput();
    }
}
