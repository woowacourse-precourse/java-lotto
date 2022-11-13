package lotto.repository;

import lotto.domain.LotteryTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LotteryTicketRepository {
    private static LotteryTicketRepository instance = new LotteryTicketRepository();

    private Map<String, LotteryTicket> store;

    private LotteryTicketRepository() {
        store = new HashMap<>();
    }

    public static LotteryTicketRepository getInstance() {
        return instance;
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

    // 테스트용 메서드
    public void clearStore() {
        store.clear();
    }
}
