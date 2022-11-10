package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Judgment {

    public static boolean hasPlace(List<Integer> computer, int computerIndex, int number) {
        return computer.get(computerIndex) == number;
    }

    public static int getCorrectCount(List<Integer> computer, List<Integer> player) {
        return (int) IntStream.range(0, player.size())
                .filter(index -> Judgment.hasPlace(computer, index, player.get(index))).count();
    }
}
