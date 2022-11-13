package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.constants.LottoConstants;

public class RandomUtil {
    private List<Integer> numbers;

    public List<Integer> pickNumbers() {
        numbers = pickUniqueNumbers();
        return sortNumbers();
    }

    public List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN,
                LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_TICKET_SIZE);
    }

    public List<Integer> sortNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
