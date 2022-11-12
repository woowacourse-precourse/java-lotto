package lotto.service;

import lotto.domain.*;
import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottosResponseDto;

import java.util.List;

public class LottoGameService {

    private final Player player;
    private Answer answer;

    public LottoGameService() {
        this.player = new Player();
    }

    public LottosResponseDto purchaseLottos(int purchasePrice) {
        int lottoCount = player.calculateLottoCount(purchasePrice);
        Lottos lottos = player.purchaseLottos(purchasePrice, RandomLottoNumberCreator.createLottoNumber(lottoCount));
        return lottos.toResponseDto();
    }

    public void createAnswer(List<Integer> answers, int bonusNumber) {
        answer = new Answer(answers, bonusNumber);
    }

    public GameResultResponseDtos playGame(int purchasePrice) {
        List<LottoResult> lottoResults = player.play(answer);
        return Referee.calculate(lottoResults, purchasePrice);
    }
}
