package lotto;

import java.util.*;

import static lotto.GameResultResponseDto.*;

public class Referee {

    public static final int CRITERION_PERCENT_VALUE = 100;
    public static final int CRITERION_ROUND_VALUE = 10;

    public static GameResultResponseDto calculate(List<LottoResult> lottoResults, int purchasePrice) {
        double earningPrice = calculateEarningPrice(purchasePrice, LottoResult.sumWinnerPrice(lottoResults));
        Map<String, LottoResultResponseDto> responseDtos = createResponseDtos(lottoResults);

        return new GameResultResponseDto(earningPrice, responseDtos);
    }

    private static double calculateEarningPrice(int purchasePrice, int sumWinnerPrice) {
        double earningPrice = (((double) sumWinnerPrice) / purchasePrice) * CRITERION_PERCENT_VALUE;
        return calculateRound(earningPrice);
    }

    private static double calculateRound(double earningPrice) {
        return ((double) Math.round(earningPrice * CRITERION_ROUND_VALUE)) / CRITERION_ROUND_VALUE;
    }

    private static Map<String, LottoResultResponseDto> createResponseDtos(List<LottoResult> lottoResults) {
        Map<String, LottoResultResponseDto> responseDtos = new HashMap<>();

        List<LottoResult> valuesExcludeElse = LottoResult.valuesExcludeElse();
        for (LottoResult value : valuesExcludeElse) {
            int totalCount = calculateTotalCount(lottoResults, value);
            responseDtos.put(value.name(), value.toResponseDto(totalCount));
        }
        return responseDtos;
    }

    private static int calculateTotalCount(List<LottoResult> lottoResults, LottoResult value) {
        return (int) lottoResults.stream()
                .filter(value::equals)
                .count();
    }
}
