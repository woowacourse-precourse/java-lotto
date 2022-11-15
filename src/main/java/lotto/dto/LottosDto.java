package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottosDto {
    public List<Lotto> lottos;

    public LottosDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
