package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinResultStatus;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;

public class LottoService {
    public static final int LOTTO_PRICE = 1000;
    public static final int PERCENT = 100;
    public static final double SECOND_DECIMAL_PLACE = 10.0;

    public static final String NEXT_LINE = "\n";
    public static final int ONE = 1;
    public static final int ZERO = 0;
    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    public List<String> buyLottos(int inputPrice) {
        lottoRepository.generateLottos(inputPrice / LOTTO_PRICE);
        return createBuyingResultMessage();
    }

    public int getCountOfLotto() {
        return lottoRepository.findAll()
                .size();
    }

    public List<String> createBuyingResultMessage() {
        // TODO view에서 담당하는것이 맞아보임
        return List.of(String.valueOf(getCountOfLotto()), createBuyingLottoMessage());
    }

    private String createBuyingLottoMessage() {
        // TODO 리팩토링 view에서 담당하는게 맞아보임
        StringBuilder allLottoNumber = new StringBuilder();
        lottoRepository.findAll()
                .stream()
                .map(Lotto::createMessage)
                .forEach(lotto -> allLottoNumber.append(lotto)
                        .append(NEXT_LINE));
        return allLottoNumber.deleteCharAt(allLottoNumber.length() - ONE)
                .toString();
    }

    public List<WinResultStatus> createWinResults(WinningNumber winningNumber) {
        List<WinResultStatus> winResults = new ArrayList<>();
        lottoRepository.findAll()
                .forEach(lotto -> winResults.add(lotto.getWinResult(winningNumber)));
        return winResults;
    }

    public List<Object> createLottoResult(List<WinResultStatus> winResults) {
        return List.of(calculateEarningsRate(winResults), createStatistics(winResults));
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
        Map<WinResultStatus, Integer> statisticsCount = new HashMap<>();
        for (WinResultStatus winResult : winResults) {
            statisticsCount.put(winResult, statisticsCount.getOrDefault(winResult, ZERO) + ONE);
        }
        return statisticsCount;
    }

    private long calculatePrizeMoney(List<WinResultStatus> winResults) {
        return winResults.stream()
                .mapToLong(WinResultStatus::getPrizeMoney)
                .sum();
    }
}
