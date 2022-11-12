package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoTickets {
    private static final int PRICE = 1000;
    private static int PURCHASE_AMOUNT;

    public int getPaid() {
        String input = Console.readLine();
        int money = getMoney(input);
        return toLottosSize(money);
    }

    private int getMoney(String input) {
        int money = Integer.parseInt(input);
        saveAmount(money);
        return money;
    }

    private int toLottosSize(int money) {
        return money / PRICE;
    }

    private void saveAmount(int purchaseAmount) {
        LottoTickets.PURCHASE_AMOUNT = purchaseAmount;
    }

    public int getPrice() {
        return PURCHASE_AMOUNT;
    }
}