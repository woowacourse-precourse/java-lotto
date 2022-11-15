package lotto;

import java.util.*;

public class ExceptionCase {
    private static boolean checkInputSameNumber(List<Integer> input) {
        Set<Integer> inputRemoveSameNumber = new HashSet<>(input);

        if (inputRemoveSameNumber.size() != 6) {
            return false;
        }

        return true;
    }
}
