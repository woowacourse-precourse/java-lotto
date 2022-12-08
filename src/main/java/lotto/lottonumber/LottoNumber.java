package lotto.lottonumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumber {
    public static List generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
