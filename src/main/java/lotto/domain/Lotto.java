package lotto.domain;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;



public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        View view = new View();
        view.validateUniqueNumbers(numbers);
        view.validateNumberOfNumbers(numbers);
        view.validateNumbersInRange(numbers);
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }
    public List<Integer> sortLotto() {
        List<Integer> sorted = numbers;
        Collections.sort(sorted);
        return sorted;
    }
    public void printLotto() {
        List<Integer> sorted = sortLotto();
        Iterator<Integer> itr = sorted.listIterator(1);
        System.out.print("["+sorted.get(0));
        while (itr.hasNext()) {
            System.out.print(", "+itr.next());
        }
        System.out.println("]");
    }
}
