package lotto.domain;

import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottoResponseDtos;

import java.util.List;

public class Player {

    public static final int LOTTO_PRICE = 1000;

    private final Lottos lottos;
    private final int purchasePrice;

    public Player(Lottos lottos, int purchasePrice) {
        this.lottos = lottos;
        this.purchasePrice = purchasePrice;
    }

    public GameResultResponseDtos playLotto(Answer answer) {
        List<LottoResult> lottoResults = play(answer);
        return Referee.calculate(lottoResults, purchasePrice);
    }

    private List<LottoResult> play(Answer answer) {
        return answer.compare(lottos);
    }

    public LottoResponseDtos toLottoResponseDtos() {
        return lottos.toResponseDto();
    }
}
