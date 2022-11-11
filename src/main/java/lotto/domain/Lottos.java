package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottosResponseDto.*;

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

    public LottosResponseDto responseDto() {
        return new LottosResponseDto(mapToLottoResponseDtos());
    }

    private List<LottoResponseDto> mapToLottoResponseDtos() {
        return lottos.stream()
                .map(Lotto::toResponseDto)
                .collect(Collectors.toList());
    }
}
