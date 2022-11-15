package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
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
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private boolean isDuplicatedNumber(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);

        return number.size() != set.size();
    }

    public Prize[] compareLotto(Lotto winNumber, int bonusNumber) {
        int index = 0;
        Prize[] prize = Prize.values();
        Set<Integer> thisSet = new HashSet<>(this.numbers);
        Set<Integer> win = new HashSet<>(winNumber.numbers);
        Set<Integer> bonus = new HashSet<>(List.of(bonusNumber));
        win.retainAll(thisSet);
        if (win.size() == 5 && thisSet.retainAll(bonus)) {
            index = 5;
        }
        if (win.size() - 2 >= 0) {
            index = win.size() - 2;
        }
        prize[index].addCount();
        return prize;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
