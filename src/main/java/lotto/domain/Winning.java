package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Winning extends Valid {
    private List<Integer> numbers;
    private int bonus;

    public Winning() {
    }

    public void pickNum() throws IllegalArgumentException {
        String[] input = Console.readLine().split(",");
        this.numbers = saveNumbers(input);
        validate(this.numbers);
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isCorrectSize(numbers);
        isCorrectRange(numbers);
        isNoDuplicate(numbers);
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
