package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinningResultStatus;
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

    public List<WinningResultStatus> createWinningResultStatuses(WinningNumber winningNumber) {
        List<WinningResultStatus> winningResults = new ArrayList<>();
        addWinningResultsOfAllBuyingLotto(winningNumber, winningResults);
        return winningResults;
    }

    private void addWinningResultsOfAllBuyingLotto(WinningNumber winningNumber,
                                                   List<WinningResultStatus> winningResults) {
        lottoRepository.findAll()
                .forEach(lotto -> winningResults.add(lotto.getWinningResultStatus(winningNumber)));
    }

    public List<Object> createLottoResult(List<WinningResultStatus> winningResults) {
        return List.of(createStatistics(winningResults), calculateEarningsRate(winningResults));
    }

    private double calculateEarningsRate(List<WinningResultStatus> winningResults) {
        long prizeMoney = calculatePrizeMoney(winningResults);
        return getRatio(prizeMoney);
    }

    private double getRatio(long prizeMoney) {
        return Math.round(prizeMoney / (double) (getCountOfLotto() * LOTTO_PRICE) * PERCENT * SECOND_DECIMAL_PLACE)
                / SECOND_DECIMAL_PLACE;
    }

    private Map<WinningResultStatus, Integer> createStatistics(List<WinningResultStatus> winningResults) {
        Map<WinningResultStatus, Integer> statisticsCounts = new HashMap<>();
        putWinResults(winningResults, statisticsCounts);
        return statisticsCounts;
    }

    private static void putWinResults(List<WinningResultStatus> winningResults,
                                      Map<WinningResultStatus, Integer> statisticsCounts) {
        for (WinningResultStatus winningResult : winningResults) {
            statisticsCounts.put(winningResult,
                    statisticsCounts.getOrDefault(winningResult, NumberUtil.ZERO) + NumberUtil.ONE);
        }
    }

    private long calculatePrizeMoney(List<WinningResultStatus> winningResults) {
        return winningResults.stream()
                .mapToLong(WinningResultStatus::getPrizeMoney)
                .sum();
    }
}
