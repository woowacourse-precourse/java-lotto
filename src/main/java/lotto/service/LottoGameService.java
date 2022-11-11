package lotto.service;

import lotto.domain.*;
import lotto.dto.GameResultResponseDto;
import lotto.dto.LottosResponseDto;

import java.util.List;

public class LottoGameService {

    private final Player player;
    private Answer answer;

    public LottoGameService(Player player) {
        this.player = new Player();
    }

    public LottosResponseDto purchaseLottos(int purchasePrice) {
        Lottos lottos = player.purchaseLottos(purchasePrice, RandomLottoNumberCreator.createLottoNumber(purchasePrice));
        return lottos.toResponseDto();
    }

    public void createAnswer(List<Integer> answers, int bonusNumber) {
        answer = new Answer(answers, bonusNumber);
    }

    public GameResultResponseDto playGame(int purchasePrice) {
        Lottos lottos = player.getLottos();
        List<LottoResult> lottoResults = answer.play(lottos);
        return Referee.calculate(lottoResults, purchasePrice);
    }
}
