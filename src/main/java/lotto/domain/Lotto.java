package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValid(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public void isValid(List<Integer> numbers) {
        isValidSize(numbers);
        isDup(numbers);
        isValidRange(numbers);
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개만 입력할 수 있습니다.");
        }
    }

    private void isDup(List<Integer> numbers) {
        Set<Integer> dupCheck = new HashSet<>(numbers);
        if (dupCheck.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    public void isValidRange(List<Integer> numbers) {
        for(int number : numbers){
            if(!(number >= 1 && number <= 45)){
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public int checkSameCount(Lotto userLotto) {
        int count = 0;
        for (int number : userLotto.getNumbers()) {
            count += contain(number) ? 1 : 0;
        }
        return count;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(numbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        str.append("]\n");
        return str.toString();
    }

// TODO: 추가 기능 구현
}