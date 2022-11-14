package lotto.domain;

import static java.util.stream.Collectors.toMap;
import static lotto.domain.WinningCase.FIFTH_PLACE;
import static lotto.domain.WinningCase.FIRST_PLACE;
import static lotto.domain.WinningCase.FOURTH_PLACE;
import static lotto.domain.WinningCase.SECOND_PLACE;
import static lotto.domain.WinningCase.THIRD_PLACE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Buyer {

    final List<WinningCase> winningCases = List.of(
            SECOND_PLACE,
            FIFTH_PLACE,
            FOURTH_PLACE,
            THIRD_PLACE,
            FIRST_PLACE
    );
    final int normalization = 2;
    final int bonusCountPlace = 3;
    final int secondPlaceIdx = 0;

    private final int usedMoney;
    private final List<Lotto> lottos;

    private Map<WinningCase, Long> winningResult;
    private double rateOfReturn;


    public Buyer(int money) {
        lottos = LottoMachine.buyLottos(money);
        usedMoney = money;
    }

    public void checkWinningNumber(WinningNumber winningNumber) {
        winningResult = initWinningResult();

        lottos.stream()
                .filter(lotto -> winningNumber.countMatchedNumbers(lotto.getNumbers()) > normalization)
                .forEach(lotto -> {
                    long matched = winningNumber.countMatchedNumbers(lotto.getNumbers()) - normalization;
                    if (matched == bonusCountPlace && winningNumber.isBonusNumberMatched(lotto)) {
                        matched = secondPlaceIdx;
                    }
                    WinningCase key = winningCases.get((int) matched);
                    winningResult.put(key, winningResult.get(key) + 1);
                });

        calculateRateOfReturn(winningResult);
    }

    private Map<WinningCase, Long> initWinningResult() {
        return Arrays.stream(WinningCase.values())
                .collect(toMap(winningCase -> winningCase, winningCase -> 0L));
    }


    private void calculateRateOfReturn(Map<WinningCase, Long> winningResult) {
        long earnedMoney = winningResult.entrySet().stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue())
                .reduce(0L, Long::sum);

        rateOfReturn = (Math.round((float) earnedMoney / usedMoney * 10000) / 100.0);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<WinningCase, Long> getWinningResult() {
        return winningResult;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
