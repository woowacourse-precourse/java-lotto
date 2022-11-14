package lotto.service;

import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LottoService {

    public static final String CANNOT_CALCULATE_EARNINGS = "[ERROR] 수익을 구할 수 없습니다.";
    public static final double NEAREST_TENTH = 10.0;
    public static final double MAKE_PERCENT = 100.0;

    public Lottos purchaseLottos(String money) {
        return Lottos.purchaseLottos(stringToInt(money));
    }

    public Result saveResult(String winningNumbers, String bonusNumber) {
        List<Integer> winnings = convertToList(winningNumbers);
        int bonus = stringToInt(bonusNumber);

        return Result.of(winnings, bonus);
    }

    private static List<Integer> convertToList(String winningNumbers) {
        return Arrays.stream(splitNumbers(winningNumbers))
                .map(LottoService::stringToInt)
                .collect(toList());
    }

    private static String[] splitNumbers(String winningNumbers) {
        return winningNumbers.split(",");
    }

    private static int stringToInt(String number) {
        return Integer.parseInt(number);
    }

    public Map<Prize, Long> compareResult(Lottos lottos, Result result) {
        return result.compareLottos(lottos);
    }

    public Double calculateEarningRates(String inputMoney, Map<Prize, Long> winningResults) {
        Long earnings = winningResults.entrySet().stream()
                .map(winningResult -> winningResult.getKey().getMoney() * winningResult.getValue())
                .reduce(Long::sum)
                .orElseThrow(() -> new IllegalArgumentException(CANNOT_CALCULATE_EARNINGS));
        return Math.round(
                earnings * NEAREST_TENTH / Double.parseDouble(inputMoney) * MAKE_PERCENT
        ) / NEAREST_TENTH;
    }
}
