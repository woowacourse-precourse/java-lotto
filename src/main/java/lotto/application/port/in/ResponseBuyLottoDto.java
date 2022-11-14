package lotto.application.port.in;

import lotto.domain.Lotto;

import java.util.List;

public class ResponseBuyLottoDto {
    private List<Lotto> lottos;

    public ResponseBuyLottoDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
