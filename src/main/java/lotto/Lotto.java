package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    static void validateLotto(List<Integer> numbers){
        Set<Integer> numberset = new HashSet<>();

        for (int e: numbers){
            numberset.add(e);
        }

        if(numberset.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> getLotto(List<Integer> numbers) {
        return new ArrayList<>(List.copyOf(numbers));
    }
}
