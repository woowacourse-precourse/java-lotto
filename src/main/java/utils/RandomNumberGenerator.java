package utils;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * '만약 라이브러리가 더이상 지원을 안하면 어떻게 해야할까?'
 * 원래 코드는 수정하지 않고 부품처럼 갈아 끼울 수 있도록 모듈화 했습니다.
 */
public class RandomNumberGenerator {

    public static List<Integer> generateMultipleNumbers(int leftBound, int rightBound, int count) {
        return Randoms.pickUniqueNumbersInRange(leftBound, rightBound, count);
    }
}
