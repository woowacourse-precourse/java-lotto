package lotto.domain;

import lotto.domain.LotteryTicket;
import lotto.domain.LotteryResult;

import java.util.List;

public class User {
    private int money;
    private List<LotteryTicket> lotteryTickets;
    private LotteryResult lotteryResult;

    public User (int money) {
        this.money = money;
        lotteryTickets = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }
}
