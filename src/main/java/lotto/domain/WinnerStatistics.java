package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoPurchaseDto;
import lotto.controller.dto.WinnerNumberDto;

public class WinnerStatistics {

    public static final int BLANK = 0;
    public static final int FIRST_PLACE = 1;
    public static final int SECOND_PLACE = 2;
    public static final int THIRD_PLACE = 3;
    public static final int FOURTH_PLACE = 4;
    public static final int FIFTH_PLACE = 5;
    private final Map<Integer, Integer> statisticsStore;

    public WinnerStatistics(WinnerNumberDto dto, LottoPurchaseDto lottoDto) {
        statisticsStore = calculateStatistics(dto, lottoDto);
    }

    private Map<Integer, Integer> calculateStatistics(WinnerNumberDto winnerNumberDto, LottoPurchaseDto lottoDto) {
        Map<Integer, Integer> store = new HashMap<>();
        List<Integer> winnerNumbers = winnerNumberDto.getWinnerNumbers();
        int bonusNumber = winnerNumberDto.getBonusNumber();
        List<Lotto> lottos = lottoDto.getLottos();
        for (Lotto lotto : lottos) {
            int count = getMatchWinnerNumberCount(winnerNumbers, lotto);
            boolean containBonusNumber = lotto.getNumbers().contains(bonusNumber);
            int rank = getRank(count, containBonusNumber);
            store.put(rank, store.getOrDefault(rank, 0) + 1);
        }
        return store;
    }

    private static int getMatchWinnerNumberCount(List<Integer> winnerNumbers, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winnerNumbers::contains)
                .count();
    }

    private int getRank(int count, boolean containBonusNumber) {
        if (count == 3) {
            return FIFTH_PLACE;
        }
        if (count == 4) {
            return FOURTH_PLACE;
        }
        if (count == 5 && !containBonusNumber) {
            return THIRD_PLACE;
        }
        if (count == 5 && containBonusNumber) {
            return SECOND_PLACE;
        }
        if (count == 6) {
            return FIRST_PLACE;
        }
        return BLANK;
    }

    public Map<Integer, Integer> getStatisticsStore() {
        return this.statisticsStore;
    }
}
