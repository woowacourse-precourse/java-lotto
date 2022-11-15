package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortAscending(numbers);
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자이어야합니다.");
        }
        for (int n : numbers){
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다");
        }
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return (sortedNumbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
