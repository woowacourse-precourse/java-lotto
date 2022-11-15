package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

/*
 * 1~45 사이의 중복되지 않는 6개의 숫자 리스트를 생성하는 클래스
 */

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                Lotto.getStartNumber(), Lotto.getEndNumber(), Lotto.getSize())
        );
        Collections.sort(numbers);
        return numbers;
    }
}
