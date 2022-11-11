package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoDraw {

    private int totalPrizeMoney;
    private Map<String, Integer> numberOfWins = new HashMap<>();
    private final List<Integer> winningNumber;

    public LottoDraw() {
        this.totalPrizeMoney = 0;
        for (int rank = 1; rank <= 5; rank++) {
            numberOfWins.put(String.valueOf(rank) + "등", 0);
        }
        this.winningNumber = enterWinningNumber();
    }

    public List<Integer> enterWinningNumber() {
        String input = Console.readLine();
        String[] split = input.split(",");
        Integer[] numbers = Arrays.stream(split).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        return Arrays.asList(numbers);
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public Map<String, Integer> getNumberOfWins() {
        return numberOfWins;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
