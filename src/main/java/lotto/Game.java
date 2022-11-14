package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int UNIT = 1000;
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

    public int buy() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] " + UNIT + "원 단위 금액을 입력해주세요.");
        }
        return money / UNIT;
    }

    public int compareNumbers(List<Integer> numbers, List<Integer> predictedNumbers) {
        return 0;
    }

    public List<Integer> generateNumbers(int count) {
        return numbers;
    }
}
