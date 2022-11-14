package dto;

import domain.Lotto;

import java.util.List;

public class LottosDto {
    public List<Lotto> lottos;

    public LottosDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
