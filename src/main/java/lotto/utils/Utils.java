package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    private static final int INITIAL_NUMBER = 0;
    private static final String STRING_REGEX = "\\s";
    private static final String BLANK = "";

    public static String deleteAllString(String string) {
        return string.replaceAll(STRING_REGEX, BLANK);
    }

    public static List<List<Integer>> createRandomNumbers(int minNumber, int maxNumber, int columnSize, int rawSize) {
        return IntStream.range(INITIAL_NUMBER, rawSize)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, columnSize))
                .collect(Collectors.toList());
    }

}
