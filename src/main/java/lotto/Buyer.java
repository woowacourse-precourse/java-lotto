package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Buyer {
    private int money;
    private List<Lotto> lottoTickets;

    public void payMoney() {
        money = Integer.parseInt(Console.readLine());
        validate(money);
    }

    private void validate(int money) {
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLotteryTickets() {
        int ticketCount = money / 1000;
        lottoTickets = Generator.createLotteryTickets(ticketCount);
        return lottoTickets;
    }
}
