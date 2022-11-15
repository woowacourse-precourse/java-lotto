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
        setTicketCount();
        initLottoTickets();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = createNumbers();
            lottoTickets.add(new Lotto(numbers));
        }
    }

    private void setTicketCount() {
        this.ticketCount = money / 1000;
    }

    private void initLottoTickets() {
        lottoTickets = new ArrayList<>(ticketCount);
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
