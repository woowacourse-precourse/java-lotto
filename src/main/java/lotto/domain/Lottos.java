package lotto.domain;

import lotto.dto.LottoResponseDtos;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.dto.LottoResponseDtos.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto get(int index) {
        return lottos.get(index);
    }

    public int size() {
        return lottos.size();
    }

    public LottoResponseDtos toResponseDto() {
        return new LottoResponseDtos(mapToLottoResponseDtos());
    }

    private List<LottoResponseDto> mapToLottoResponseDtos() {
        return lottos.stream()
                .map(Lotto::toResponseDto)
                .collect(Collectors.toList());
    }
}
