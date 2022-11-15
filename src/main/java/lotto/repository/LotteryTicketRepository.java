package lotto.repository;

import lotto.constant.LotteryRank;
import lotto.domain.LotteryTicket;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class LotteryTicketRepository {
    private static LotteryTicketRepository instance = new LotteryTicketRepository();

    private Map<String, LotteryTicket> store;
    private Map<String, LotteryRank> drawResult;

    private LotteryTicketRepository() {
        store = new HashMap<>();
        drawResult = new HashMap<>();
    }

    public static LotteryTicketRepository getInstance() {
        return instance;
    }

    public void addLotteryTicket (LotteryTicket lotteryTicket) {
        store.put(lotteryTicket.getLotteryId(), lotteryTicket);
        drawResult.put(lotteryTicket.getLotteryId(), LotteryRank.BEFORE_DRAW);
    }

    public void updateResultById (String lotteryId, LotteryRank rank) {
        drawResult.put(lotteryId, rank);
    }

    public Optional<LotteryTicket> findTicketById(String lotteryId) {
        return Optional.ofNullable(store.get(lotteryId));
    }

    public Optional<LotteryRank> findRankById (String lotteryId) {
        return Optional.ofNullable(drawResult.get(lotteryId));
    }

    public List<String> findAllTicketId() {
        return new ArrayList<>(store.keySet());
    }

    public int getSize() {
        return store.size();
    }

    // 테스트용 메서드
    public void clearStore() {
        store.clear();
    }

    // 테스트용 메서드
    public void clearDrawResult() {
        drawResult.clear();
    }
}
