package lotto.data.dto;

import java.util.Collections;
import java.util.List;

public class LottoBundleDto {

    private final List<Lotto> lottos;

    public LottoBundleDto(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
