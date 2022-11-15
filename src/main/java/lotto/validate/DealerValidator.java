package lotto.validate;

import lotto.log.CustomLogger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoGenerator.*;
import static lotto.log.CustomLogger.*;

public class DealerValidator extends Validator {

    public static void validAnswerNumber(String numbers) {
        List<Integer> results = Arrays.stream(numbers.split(","))
                .filter(Validator::isNumber)
                .map(Integer::parseInt)
                .filter(Validator::isBetween1And45)
                .distinct()
                .collect(Collectors.toList());

        if (results.size() != LOTTO_NUMBER_COUNT) {
            LOG.severe("쉼표를 기준으로 중복되지 않는 6개의 로또 번호를 입력하지 않았습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validLottoContainsNumber(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            LOG.severe("당첨 번호와 중복되었습니다.");
            throw new IllegalArgumentException();
        }
    }
}
