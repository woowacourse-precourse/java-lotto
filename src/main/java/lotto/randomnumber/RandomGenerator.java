package lotto.randomnumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 난수 생성과 관련된 클래스입니다.
 */
public class RandomGenerator {

    /**
     * 랜덤 로또 번호를 생성하는 기능을 담당합니다.
     * @return 1~45의 범위를 갖는 중복되지 않은 일반 로또 번호 6개
     */
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
