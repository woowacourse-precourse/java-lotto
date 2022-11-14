package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.constants.LottoConstants;

public class RandomUtil {
    public static List<Integer> pickNumbers() {
        List<Integer> numbers = pickUniqueNumbers();
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN,
                LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_TICKET_SIZE);
    }
}
