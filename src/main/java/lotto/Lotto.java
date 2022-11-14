package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개 있어야 합니다.");
            throw new IllegalArgumentException();
        }
        if (isDuplicatedNumber(numbers)) {
            System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto() {
        sort();
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private void sort() {
        Collections.sort(this.numbers);
    }

    private boolean isDuplicatedNumber(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);

        return number.size() != set.size();
    }
}
