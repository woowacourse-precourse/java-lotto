package lotto.domain;

import java.util.List;

public class Judgment {

    public static boolean hasPlace(List<Integer> computer, int computerIndex, int number) {
        return computer.get(computerIndex) == number;
    }

}
