package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomGeneratorUtil {

    private RandomGeneratorUtil() {
    }

    public static List<Integer> generateDistinctSixRandomNumberInRangeOneToFortyFive(){

        List<Integer> numberDistinctDigitList = new ArrayList<>();
        while (numberDistinctDigitList.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numberDistinctDigitList.contains(randomNumber)) {
                numberDistinctDigitList.add(randomNumber);
            }
        }

        return numberDistinctDigitList;
    }


}
