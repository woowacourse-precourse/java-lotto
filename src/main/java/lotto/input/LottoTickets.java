package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoTickets {
    private static final int PRICE = 1000;
    private static int PURCHASE_AMOUNT;

    public int getPaid() {
        String input = getInput();
        int money = Integer.parseInt(input);

        saveAmount(money);
        return sizeLottos(money);
    }

    private String getInput() {
        return Console.readLine();
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