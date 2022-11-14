package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> numbers  = new ArrayList<>();
    private List<List<Integer>> buyNumbers = new ArrayList<>();
    private int bonus;

    public void setWinningNumbers(List<Integer> numbers) {

    }

    public void setBonus(int bonus) {

    }

    public List<Integer> getWinningNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    public int buy(List<Integer> numbers) throws IllegalArgumentException {
        return -1;
    }

    public int compareNumbers(List<Integer> numbers, List<Integer> predictedNumbers) {
        return 0;
    }

    public List<Integer> generateNumbers(int count) {
        return numbers;
    }
}
