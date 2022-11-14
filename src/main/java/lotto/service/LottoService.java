package lotto.service;

import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LottoService {
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

    public Map<Prize, Long> calculateEarningRates(Lottos lottos, Result result) {
        return result.compareLottos(lottos);
    }
}
