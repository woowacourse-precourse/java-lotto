package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class LottoTickets {
    private static final int PRICE = 1000;

    public int getPaid() {
        String input = Console.readLine();
        int money = Integer.parseInt(input);
        return toLottosSize(money);
    }

    private int toLottosSize(int money) {
        return money / PRICE;
    }
}