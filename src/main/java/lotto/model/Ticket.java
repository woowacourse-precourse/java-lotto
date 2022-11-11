package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private final List<Lotto> lotteries;
    private final int money;

    public Ticket(int money) {
        this.money = money;
        List<Lotto> ticket = createTicket(money);
        validateTicket(ticket);
        this.lotteries = ticket;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getMoney() {
        return money;
    }

    private List<Lotto> createTicket(int money) {
        List<Lotto> ticket = new ArrayList<>();
        int lottoCount = money / 1000;

        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> lottoNumber = createLotto();
            ticket.add(new Lotto(lottoNumber));
        }

        return ticket;
    }

    private static List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void validateTicket(List<Lotto> ticket) {
        if (ticket.size() != money / 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 발행 개수가 올바르지 않습니다.");
        }
    }
}
