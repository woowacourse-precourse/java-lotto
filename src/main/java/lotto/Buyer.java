package lotto;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static lotto.WinningCase.*;

public class Buyer {

    final List<WinningCase> winningCases = List.of(
            SECOND_PLACE,
            FIFTH_PLACE,
            FOURTH_PLACE,
            THIRD_PLACE,
            FIFTH_PLACE
    );
    final int normalization = 2;
    final int bonusCountPlace = 3;
    final int secondPlaceIdx = 0;

    double rateOfReturn;

    private final int usedMoney;
    private final List<Lotto> lottos;


    Buyer(int money){
        lottos = LottoMachine.buyLottos(money);
        usedMoney = money;
    }

    public Map<WinningCase, Long> checkWinningNumber(WinningNumber winningNumber){
        Map<WinningCase, Long> winningResult = lottos.stream()
                .filter(lotto -> winningNumber.countMatchedNumbers(lotto) > normalization)
                .collect(groupingBy(lotto -> {
                    long matched = winningNumber.countMatchedNumbers(lotto) - normalization;
                    if( matched == bonusCountPlace && winningNumber.isBonusNumberMatched(lotto)) {
                        matched = secondPlaceIdx;
                    }
                    return winningCases.get((int) matched);
        }, counting()));

        calculateRateOfReturn(winningResult);

        return winningResult;
    }

    private void calculateRateOfReturn(Map<WinningCase, Long> winningResult){
        long earnedMoney = winningResult.entrySet().stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue())
                .reduce(0L, Long::sum);

        rateOfReturn = (Math.round((float) earnedMoney / usedMoney * 10000) / 100.0);
    }

}
