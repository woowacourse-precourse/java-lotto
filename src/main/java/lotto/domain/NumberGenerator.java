package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
    public static List<Integer> randomNumbers = new ArrayList<>();
    public static List<Integer> createRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randomNumbers = numbers;
        // 번호가 부여될 때마다 numbers 출력
        System.out.println(numbers);
        return randomNumbers;
    }
}
