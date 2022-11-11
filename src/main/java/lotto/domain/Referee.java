package lotto.domain;

import lotto.dto.GameResultResponseDtos;

import java.util.*;

import static lotto.dto.GameResultResponseDtos.*;

public class Referee {

    public static final int CRITERION_PERCENT_VALUE = 100;
    public static final int CRITERION_ROUND_VALUE = 10;

    public static GameResultResponseDtos calculate(List<LottoResult> lottoResults, int purchasePrice) {
        double earningPrice = calculateEarningPrice(purchasePrice, LottoResult.sumWinnerPrice(lottoResults));
        Map<String, GameResultResponseDto> responseDtos = createResponseDtos(lottoResults);

        return new GameResultResponseDtos(earningPrice, responseDtos);
    }

    private static double calculateEarningPrice(int purchasePrice, int sumWinnerPrice) {
        double earningPrice = (((double) sumWinnerPrice) / purchasePrice) * CRITERION_PERCENT_VALUE;
        return calculateRound(earningPrice);
    }

    private static double calculateRound(double earningPrice) {
        return ((double) Math.round(earningPrice * CRITERION_ROUND_VALUE)) / CRITERION_ROUND_VALUE;
    }

    private static Map<String, GameResultResponseDto> createResponseDtos(List<LottoResult> lottoResults) {
        Map<String, GameResultResponseDto> responseDtos = new HashMap<>();

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
