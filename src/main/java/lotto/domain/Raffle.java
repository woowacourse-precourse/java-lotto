package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Raffle {

    private static final int PRIZE_2 = 5;
    private static final int PRIZE_MIN = 3;

    public List<Integer> prize = new ArrayList<>(List.of(0, 0, 0, 0, 0));

    public Raffle(List<Lotto> lottoNumber, int lottoCount, Lotto pickLottoNumber, int pickBonusNumber) {
        doRaffle(lottoNumber, lottoCount, pickLottoNumber, pickBonusNumber);
    }

    private void doRaffle(List<Lotto> lottoNumber, int lottoCount, Lotto pickLottoNumber, int pickBonusNumber) {
        for (int i = 0; i < lottoCount; i++) {
            int winCount = lottoNumber.get(i).checkRaffle(pickLottoNumber);
            boolean isBonus = lottoNumber.get(i).checkBounsInclude(pickBonusNumber);
            if (winCount == PRIZE_2 && isBonus) {
                prize.set(3, prize.get(3) + 1);
            }
            if (winCount >= PRIZE_MIN) {
                prize.set(winCount - 3, prize.get(winCount - 3) + 1);
            }
        }
    }
}
