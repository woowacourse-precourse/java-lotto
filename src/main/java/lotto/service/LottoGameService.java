package lotto.service;

import lotto.domain.*;
import lotto.dto.GameResultResponseDtos;
import lotto.dto.LottoResponseDtos;

import java.util.List;

public class LottoGameService {

    private Player player;
    private Answer answer;

    public void createPlayer(int purchasePrice) {
        player = new Player(LottosCashier.create(purchasePrice), purchasePrice);
    }

    public void createAnswer(List<Integer> answers, int bonusNumber) {
        answer = new Answer(answers, bonusNumber);
    }

    public LottoResponseDtos getPurchaseLottos() {
        return player.toLottoResponseDtos();
    }

    public GameResultResponseDtos playGame() {
        return player.playLotto(answer);
    }
}
