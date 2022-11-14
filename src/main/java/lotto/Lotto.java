package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        HashSet<Integer> playerNumbers = Model.MakeListToSet(numbers);
        Controller.ValidatePlayerNumber(playerNumbers);
        this.numbers = numbers;
    }
}
