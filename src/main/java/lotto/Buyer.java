package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Buyer {
    private int money;
    private int ticketCount;
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
        createLotteryTickets();
        return lottoTickets;
    }

    public void createLotteryTickets() {
    }
}
