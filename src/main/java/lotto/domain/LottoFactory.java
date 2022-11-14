package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.LottoNumberGenerator;

public class LottoFactory {

    public static WinLotto createWinLotto(List<Integer> winLotto, int bonus) {
        return WinLotto.of(Lotto.from(winLotto),bonus);
    }

    public static Lottos createRandomLottoByCnt(int lottoCnt) {
        List<Lotto> lottosList = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottosList.add(Lotto.from(LottoNumberGenerator.generate()));
        }
        return Lottos.of(lottosList);
    }
}
