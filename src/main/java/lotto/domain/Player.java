package lotto.domain;

import java.util.List;

public class Player {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Player(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
