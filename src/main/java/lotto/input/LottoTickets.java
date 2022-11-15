package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.exception.AmountPaymentException;

public class LottoTickets {
    private static final int PRICE = 1000;
    private static int PURCHASE_AMOUNT;

    public int getPaid() {
        AmountPaymentException amountPaymentException = new AmountPaymentException();
        String input = getInput(amountPaymentException);

        int money = Integer.parseInt(input);

        amountPaymentException.inputVerification(money);
        saveAmount(money);

        return sizeLottos(money);
    }

    private String getInput(AmountPaymentException amountPaymentException) {
        String readLine = Console.readLine();
        amountPaymentException.validateCharacters(readLine);
        return readLine;
    }

    public int sizeLottos(int money) {
        return money / PRICE;
    }

    private void saveAmount(int purchaseAmount) {
        LottoTickets.PURCHASE_AMOUNT = purchaseAmount;
    }

    public int getPrice() {
        return PURCHASE_AMOUNT;
    }
}