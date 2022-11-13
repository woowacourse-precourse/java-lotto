package lotto.repository;

import lotto.domain.LotteryTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LotteryTicketRepository {
    private Map<String, LotteryTicket> store;

    public LotteryTicketRepository() {
        store = new HashMap<>();
    }

    public void addLotteryTicket (LotteryTicket lotteryTicket) {
        store.put(lotteryTicket.getLotteryId(), lotteryTicket);
    }

    public Optional<LotteryTicket> findByLotteryId (String lotteryId) {
        return Optional.ofNullable(store.get(lotteryId));
    }

    public int getSize() {
        return store.size();
    }
}
