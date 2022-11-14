package lotto.service;


import lotto.domain.GameSet;
import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {
    void lotteryCheck(Lotto inputLotto, Lotto awardLotto, int bonusNumber);
    void play(List<Lotto> generatedLotto, GameSet gameSet);
    void updateGameSet(LottoProperties lottoProperties, int correct);
}
