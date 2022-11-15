package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    private static final int FROM_INDEX = 1;
    private static final int END_INDEX = 45;
    private static final int PICKING_NUMBER = 6;

    public static List<Integer> generateSixRandomNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }


}
