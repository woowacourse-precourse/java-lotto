package lotto;

import java.util.*;

import static lotto.GameResultResponseDto.*;

public class Referee {

    public static final int PERCENT_VALUE = 100;

    public static GameResultResponseDto calculate(List<LottoResult> lottoResults, int purchasePrice) {
        double earningPrice = calculateEarningPrice(purchasePrice, LottoResult.sumWinnerPrice(lottoResults));
        HashMap<String, LottoResultResponseDto> responseDtos = createResponseDtos(lottoResults);

        return new GameResultResponseDto(earningPrice, responseDtos);
    }

    private static double calculateEarningPrice(int purchasePrice, int sumWinnerPrice) {
        return (((double) sumWinnerPrice) / purchasePrice) * PERCENT_VALUE;
    }

    private static HashMap<String, LottoResultResponseDto> createResponseDtos(List<LottoResult> lottoResults) {
        HashMap<String, LottoResultResponseDto> responseDtos = new HashMap<>();

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
