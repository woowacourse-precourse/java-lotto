package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoCalculator {
    private static final int MAP_SIZE = 1024;
    private static final int ONE = 1;
    private static final int WIN_FIRST_COUNT = 6;
    private static final int WIN_THIRD_COUNT = 5;
    private static final int WIN_FOURTH_COUNT = 4;
    private static final int WIN_FIFTH_COUNT = 3;

    public LottoCalculator() {

    }

    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Map<LottoRankingType, Integer> getRankings(List<Integer> numbers, int bonusNumber, List<Lotto> lottos) {
        Map<LottoRankingType, Integer> lottoRankingTypes = new HashMap<>(MAP_SIZE);
        lottoRankingTypesInitialize(lottoRankingTypes);
        for (Lotto lotto : lottos) {
            int winNumber = getWinNumberCount(numbers, lotto);
            boolean winBonus = lotto.getNumbers().contains(bonusNumber);
            LottoRankingType lottoRankingType = getLottoRanking(winNumber, winBonus);

            lottoRankingTypes.put(lottoRankingType, lottoRankingTypes.get(lottoRankingType).intValue() + ONE);
        }
        return lottoRankingTypes;
    }


    private void lottoRankingTypesInitialize(Map<LottoRankingType, Integer> lottoRankingTypes) {
        lottoRankingTypes.put(LottoRankingType.FIRST_PLACE, 0);
        lottoRankingTypes.put(LottoRankingType.SECOND_PLACE, 0);
        lottoRankingTypes.put(LottoRankingType.THIRD_PLACE, 0);
        lottoRankingTypes.put(LottoRankingType.FOURTH_PLACE, 0);
        lottoRankingTypes.put(LottoRankingType.FIFTH_PLACE, 0);
        lottoRankingTypes.put(LottoRankingType.BANG, 0);
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
