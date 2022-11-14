package lotto.data.entity;

import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final Long ownerId;
    private final Long roundId;
    private final List<Lotto> lottos;

    public LottoBundle(Long ownerId, Long roundId, List<Lotto> lottos) {
        this.ownerId = ownerId;
        this.roundId = roundId;
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
