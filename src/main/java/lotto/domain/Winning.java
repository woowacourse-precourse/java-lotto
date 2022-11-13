package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private List<Integer> numbers;
    private int bonus;

    public Winning() {
    }

    public void pickNum() {
        String[] input = Console.readLine().split(",");
        this.numbers = saveNumbers(input);
    }

    private List<Integer> saveNumbers(String[] numbers) {
        List<Integer> save = new ArrayList<>();
        for (String number : numbers) {
            save.add(Integer.parseInt(number));
        }
        return save;
    }

    public void compare(User user) {

    }
}
