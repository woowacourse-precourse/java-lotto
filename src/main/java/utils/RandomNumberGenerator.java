package utils;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generateMultipleNumbers(int leftBound, int rightBound, int count) {
        return Randoms.pickUniqueNumbersInRange(leftBound, rightBound, count);
    }
}
