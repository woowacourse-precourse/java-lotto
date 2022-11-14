package lotto.service;


import lotto.domain.GameSet;
import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {
    int lotteryCheck(Lotto inputLotto, Lotto awardLotto, int bonusNumber);
    void play(List<Lotto> generatedLotto, GameSet gameSet);
}
