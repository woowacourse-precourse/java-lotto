package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoCalculator {
    private static final int MAP_SIZE = 1024;
    private static final int LIST_SIZE = 1024;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int WIN_FIRST_COUNT = 6;
    private static final int WIN_THIRD_COUNT = 5;
    private static final int WIN_FOURTH_COUNT = 4;
    private static final int WIN_FIFTH_COUNT = 3;

    public LottoCalculator() {

    }

    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT);
    }

    public ArrayList<ArrayList<Integer>> getDisplayLottoNumbers(List<Lotto> lottos) {
        ArrayList<ArrayList<Integer>> displayLottoNumbers = new ArrayList<>(LIST_SIZE);
        for (Lotto lotto : lottos) {
            ArrayList<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            bubbleSort(numbers);
            displayLottoNumbers.add(numbers);
        }
        return displayLottoNumbers;
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
        lottoRankingTypes.put(LottoRankingType.FIRST_PLACE, ZERO);
        lottoRankingTypes.put(LottoRankingType.SECOND_PLACE, ZERO);
        lottoRankingTypes.put(LottoRankingType.THIRD_PLACE, ZERO);
        lottoRankingTypes.put(LottoRankingType.FOURTH_PLACE, ZERO);
        lottoRankingTypes.put(LottoRankingType.FIFTH_PLACE, ZERO);
        lottoRankingTypes.put(LottoRankingType.BANG, ZERO);
    }

    private int getWinNumberCount(List<Integer> winningNumbers, Lotto lotto) {
        int winNumber = ZERO;
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

    private void bubbleSort(List<Integer> numbers) {
        for (int i = ONE; i < numbers.size(); i++) {
            for (int j = ZERO; j < numbers.size() - i; j++) {
                swapNumber(numbers, j, j + ONE);
            }
        }
    }

    private void swapNumber(List<Integer> numbers, int thisIndex, int nextIndex) {
        int thisNumber = numbers.get(thisIndex).intValue();
        int nextNumber = numbers.get(nextIndex).intValue();
        if (thisNumber > nextNumber) {
            numbers.set(thisIndex, nextNumber);
            numbers.set(nextIndex, thisNumber);
        }
    }
}
