package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.dto.LottosDto;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> randomNumbers) {
        lottos = randomNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public LottosDto toDto() {
        return new LottosDto(lottos);
    }
}
