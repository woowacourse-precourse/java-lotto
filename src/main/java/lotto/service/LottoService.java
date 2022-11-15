package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.constants.utils.NumberUtil;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;
    public static final int PERCENT = 100;
    public static final double SECOND_DECIMAL_PLACE = 10.0;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public List<Object> buyLottos(int inputPrice) {
        lottoRepository.generateLottos(inputPrice / LOTTO_PRICE);
        return createBuyingResult();
    }

    public int getCountOfLotto() {
        return lottoRepository.findAll()
                .size();
    }

    private List<Object> createBuyingResult() {
        return List.of(getCountOfLotto(), lottoRepository.findAll());
    }

    public List<WinResultStatus> createWinResultStatuses(WinningNumber winningNumber) {
        List<WinResultStatus> winResults = new ArrayList<>();
        lottoRepository.findAll()
                .forEach(lotto -> winResults.add(lotto.getWinResult(winningNumber)));
        return winResults;
    }

    public List<Object> createLottoResult(List<WinResultStatus> winResultStatuses) {
        return List.of(createStatistics(winResultStatuses), calculateEarningsRate(winResultStatuses));
    }

    private double calculateEarningsRate(List<WinResultStatus> winResults) {
        long prizeMoney = calculatePrizeMoney(winResults);
        return getRatio(prizeMoney);
    }

    private double getRatio(long prizeMoney) {
        return Math.round(prizeMoney / (double) (getCountOfLotto() * LOTTO_PRICE) * PERCENT * SECOND_DECIMAL_PLACE)
                / SECOND_DECIMAL_PLACE;
    }

    private Map<WinResultStatus, Integer> createStatistics(List<WinResultStatus> winResults) {
        Map<WinResultStatus, Integer> statisticsCounts = new HashMap<>();
        for (WinResultStatus winResult : winResults) {
            statisticsCounts.put(winResult, statisticsCounts.getOrDefault(winResult, NumberUtil.ZERO) + NumberUtil.ONE);
        }
        return statisticsCounts;
    }

    private long calculatePrizeMoney(List<WinResultStatus> winResults) {
        return winResults.stream()
                .mapToLong(WinResultStatus::getPrizeMoney)
                .sum();
    }
}
