package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : NumberGenerator
 * author : gim-yeong-geun
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/09         gim-yeong-geun          최초 생성
 */
public class NumberGenerator {
    public List<Integer> createRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(numbers);
        return numbers;
    }
}
