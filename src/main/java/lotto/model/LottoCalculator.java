package lotto.model;

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

    public List<LottoRankingType> getLottoRanking(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        List<LottoRankingType> lottoRankingTypes = new ArrayList<>(ARRAY_LIST_SIZE);
        for (Lotto lotto : lottos) {
            int winNumber = getWinNumberCount(winningNumbers, lotto);
            boolean winBonus = lotto.getNumbers().contains(bonusNumber);

            lottoRankingTypes.add(getLottoRanking(winNumber, winBonus));
        }
        return lottoRankingTypes;
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

    private LottoRankingType getLottoRanking(int winNumber, boolean winBonus) {
        if (winNumber == WIN_FIRST_COUNT) {
            return LottoRankingType.FIRST_PLACE;
        }
        if (winNumber == WIN_THIRD_COUNT) {
            return checkBonus(winBonus);
        }
        if (winNumber == WIN_FOURTH_COUNT) {
            return LottoRankingType.FOURTH_PLACE;
        }
        if (winNumber == WIN_FIFTH_COUNT) {
            return LottoRankingType.FIFTH_PLACE;
        }
        return LottoRankingType.BANG;
    }

    private LottoRankingType checkBonus(boolean winBonus) {
        if (winBonus) {
            return LottoRankingType.SECOND_PLACE;
        }
        return LottoRankingType.THIRD_PLACE;
    }
}
