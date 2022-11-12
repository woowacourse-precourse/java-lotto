package lotto.domain;


import java.util.List;

public class WinningNum {

    private final List<Integer> numbers;

    public WinningNum(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}