package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private final Message message = new Message();
    private final ProcessInput processInput = new ProcessInput();
    public void start() {
        try {
            Integer purchasePrice = inputPurchasePrice();
        } catch (IllegalArgumentException e) {
            //
        }
    }

    private Integer inputPurchasePrice() throws IllegalArgumentException {
        message.printPurchaseMsg();
        String price = Console.readLine();

        return processInput.convertToInteger(price);
    }
}
