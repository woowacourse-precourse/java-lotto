package lotto.domain;

import lotto.dto.GameResultResponseDtos;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.dto.GameResultResponseDtos.*;

public class Referee {

    private static final int CRITERION_PERCENT_VALUE = 100;
    private static final int CRITERION_ROUND_VALUE = 10;

    private Referee() {
    }

    public static GameResultResponseDtos calculate(List<LottoResult> lottoResults, int purchasePrice) {
        double earningPrice = calculateEarningPrice(purchasePrice, LottoResult.sumWinnerPrice(lottoResults));
        List<GameResultResponseDto> responseDtos = createResponseDtos(lottoResults);
        return new GameResultResponseDtos(earningPrice, responseDtos);
    }

    private static double calculateEarningPrice(int purchasePrice, int sumWinnerPrice) {
        double earningPrice = (((double) sumWinnerPrice) / purchasePrice) * CRITERION_PERCENT_VALUE;
        return calculateRound(earningPrice);
    }

    private static double calculateRound(double earningPrice) {
        return ((double) Math.round(earningPrice * CRITERION_ROUND_VALUE)) / CRITERION_ROUND_VALUE;
    }

    private static List<GameResultResponseDto> createResponseDtos(List<LottoResult> lottoResults) {
        return Arrays.stream(LottoResult.values())
                .filter(value -> !value.isElse())
                .map(value -> value.toResponseDto(calculateHaveCount(lottoResults, value)))
                .sorted(Comparator.comparing(GameResultResponseDto::getWinnerPrice))
                .collect(Collectors.toList());
    }

    private static int calculateHaveCount(List<LottoResult> lottoResults, LottoResult value) {
        return (int) lottoResults.stream()
                .filter(value::equals)
                .count();
    }
}
