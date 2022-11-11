package lotto.dto;

import lotto.domain.Lottos;

import java.util.Collections;
import java.util.List;

public class LottosDTO {
    private final List<List<Integer>> lottos;
    
    public LottosDTO(final Lottos lottos) {
        this.lottos = lottos.lottos();
    }
    
    public List<List<Integer>> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
