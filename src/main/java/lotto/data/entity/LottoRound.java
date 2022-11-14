package lotto.data.entity;

import java.util.HashMap;
import java.util.List;

public class LottoRound {

    private final Long roundId;
    private final HashMap<Long, List<LottoBundle>> userIdMapper;

    public LottoRound(Long roundId) {
        this.roundId = roundId;
        this.userIdMapper = new HashMap<>();
    }

    public Long getRoundId() {
        return roundId;
    }

    public HashMap<Long, List<LottoBundle>> getUserIdMapper() {
        return userIdMapper;
    }
}
