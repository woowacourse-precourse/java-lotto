package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoTickets {
    private static final int PRICE = 1000;
    private static int purchaseAmount;

    public int getPaid() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = getMoney(input);
        System.out.println();
        return toLottosSize(money);
    }

    private int getMoney(String input) {
        int money = Integer.parseInt(input);
        int purchaseAmount = money;
        amount(purchaseAmount);
        return money;
    }

    private int toLottosSize(int money) {
        return money / PRICE;
    }

    private void amount(int purchaseAmount) {
        LottoTickets.purchaseAmount = purchaseAmount;
    }

    public int getPrice() {
        return purchaseAmount;
    }
}