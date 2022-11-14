package lotto.domain;

import java.util.List;

public class User {
    private List<Lotto> tickets;
    private int money;

    public List<Lotto> getTickets() {
        return tickets;
    }

    public int getMoney() {
        return money;
    }

    public void setTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
