package lotto.model;

import java.util.List;

public class Computer {
    private List<List<Integer>> randomNumbers;

    public Computer(List<List<Integer>> randomNumber) {
        this.randomNumbers = randomNumber;
    }

    public List<List<Integer>> getRandomNumbers() {
        return randomNumbers;
    }
}
