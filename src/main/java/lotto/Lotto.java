package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        Validation validation = new Validation();
        validation.checkDuplicate(numbers);
        for (int number : numbers) {
            validation.checkNumberInRange(number);
        }
    }

    public boolean hasNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public String sortedNumbersToString() {
        return sortedNumbers().toString();
    }

    public ArrayList<Integer> sortedNumbers() {
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int number : numbers){
            sorted.add(number);
        }
        Collections.sort(sorted);
        return sorted;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
