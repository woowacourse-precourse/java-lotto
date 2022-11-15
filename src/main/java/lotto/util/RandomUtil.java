package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {
    public static List<Integer> pickNumbers() {
        List<Integer> numbers = pickUniqueNumbers();
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER,
                LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_TICKET_SIZE);
    }
}
