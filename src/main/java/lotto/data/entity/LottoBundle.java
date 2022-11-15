package lotto.data.entity;

import java.util.Collections;
import java.util.List;
import lotto.type.ExceptionType;

public class LottoBundle {

    private final Long ownerId;
    private final Long roundId;
    private final List<Lotto> lottos;

    public LottoBundle(Long ownerId, Long roundId, List<Lotto> lottos) {
        validate(lottos);
        this.ownerId = ownerId;
        this.roundId = roundId;
        this.lottos = Collections.unmodifiableList(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if(hasNoElement(lottos)) {
            throw ExceptionType.EMPTY.getException();
        }
    }

    private boolean hasNoElement(List<Lotto> lottos) {
        return lottos.isEmpty();
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
