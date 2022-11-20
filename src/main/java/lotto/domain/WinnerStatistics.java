package lotto.domain;

import static lotto.domain.LottoInfo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoPurchaseDto;
import lotto.controller.dto.WinnerNumberDto;

public class WinnerStatistics {

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
        if (count == FIFTH_PLACE.getMatchCount()) {
            return FIFTH_PLACE.getWinning();
        }
        if (count == FOURTH_PLACE.getMatchCount()) {
            return FOURTH_PLACE.getWinning();
        }
        if (count == THIRD_PLACE.getMatchCount() && !containBonusNumber) {
            return THIRD_PLACE.getWinning();
        }
        if (count == SECOND_PLACE.getMatchCount() && containBonusNumber) {
            return SECOND_PLACE.getWinning();
        }
        if (count == FIRST_PLACE.getMatchCount()) {
            return FIRST_PLACE.getWinning();
        }
        return BLANK.getWinning();
    }

    public Map<Integer, Integer> getStatisticsStore() {
        return this.statisticsStore;
    }
}
