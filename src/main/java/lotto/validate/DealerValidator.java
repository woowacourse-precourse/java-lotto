package lotto.validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.LottoGenerator.*;

public class DealerValidator extends Validator {

    public static void validAnswerNumber(String numbers) {
        List<Integer> results = Arrays.stream(numbers.split(","))
                .filter(Validator::isNumber)
                .map(Integer::parseInt)
                .filter(Validator::isBetween1And45)
                .distinct()
                .collect(Collectors.toList());

        if (results.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("쉼표를 기준으로 중복되지 않는 6개의 로또 번호를 입력하지 않았습니다.");
        }
    }

    public static void validLottoContainsNumber(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException("당첨 번호와 중복되었습니다.");
        }
    }
}
