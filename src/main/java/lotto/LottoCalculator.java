package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoCalculator {
    private static final int ARRAY_LIST_SIZE = 1024;
    private static final int WIN_FIRST_COUNT = 6;
    private static final int WIN_THIRD_COUNT = 5;
    private static final int WIN_FOURTH_COUNT = 4;
    private static final int WIN_FIFTH_COUNT = 3;

    public LottoCalculator() {

    }
    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<LottoRanking> getLottoRanking(List<Integer> winningNumbers, int bonusNumber,  List<Lotto> lottos) {
        List<LottoRanking> lottoRankings = new ArrayList<>(ARRAY_LIST_SIZE);
        for (Lotto lotto : lottos) {
            int winNumber = getWinNumberCount(winningNumbers, lotto);
            boolean winBonus = lotto.getNumbers().contains(bonusNumber);

            lottoRankings.add(getLottoRanking(winNumber, winBonus));
        }
        return lottoRankings;
    }

    private int getWinNumberCount(List<Integer> winningNumbers, Lotto lotto) {
        int winNumber = 0;
        for (Integer number : winningNumbers) {
            if (lotto.getNumbers().contains(number)) {
                ++winNumber;
            }
        }
        return winNumber;
    }

    private LottoRanking getLottoRanking(int winNumber, boolean winBonus) {
        if (winNumber == WIN_FIRST_COUNT) {
            return LottoRanking.FIRST_PLACE;
        }
        if (winNumber == WIN_THIRD_COUNT) {
            return checkBonus(winBonus);
        }
        if (winNumber == WIN_FOURTH_COUNT) {
            return LottoRanking.FOURTH_PLACE;
        }
        if (winNumber == WIN_FIFTH_COUNT) {
            return LottoRanking.FIFTH_PLACE;
        }
        return LottoRanking.BANG;
    }

    private LottoRanking checkBonus(boolean winBonus) {
        if (winBonus) {
            return LottoRanking.SECOND_PLACE;
        }
        return LottoRanking.THIRD_PLACE;
    }
}
