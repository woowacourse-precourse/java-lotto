package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoDto {
    private final List<List<Integer>> lottos;

    public LottoDto(List<Lotto> lottos) {
        this.lottos = lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
