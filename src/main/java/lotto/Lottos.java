package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;
import user.BonusNumber;
import user.WinNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseCount) {
        generateLottos(purchaseCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void generateLottos(int purchaseCount) {
        while (purchaseCount > 0) {
            List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_VALUE,
                    LottoConstants.MAX_LOTTO_VALUE,
                    LottoConstants.LOTTO_NUM);

            lottos.add(new Lotto(lotteryNumbers));
            purchaseCount--;
        }
    }

    public WinningStatistic calculateWinningStatus(WinNumber winNumber, BonusNumber bonusNumber) {
        EnumMap<Wins, Integer> winningResult = new EnumMap<>(Wins.class);
        Arrays.stream(Wins.values())
                .forEach(win -> winningResult.put(win, 0));

        for (Lotto lotto : lottos) {
            Wins wins = lotto.countMatchingNumber(winNumber, bonusNumber);

            winningResult.computeIfPresent(wins, (key, value) -> value + 1);
        }

        return new WinningStatistic(winningResult);
    }
}
