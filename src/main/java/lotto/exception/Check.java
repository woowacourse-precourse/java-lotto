package lotto.exception;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Check {

    public boolean checkDuplicate(List<Integer> numbers) {
        HashSet<Integer> duplicateSet = new HashSet<>(numbers);
        return duplicateSet.size() == 6;
    }

    public boolean checkDuplicate(List<Integer> numbers, int number) {
        HashSet<Integer> duplicateSet = new HashSet<>(numbers);
        duplicateSet.add(number);
        return duplicateSet.size() == 7;
    }

    public boolean checkRange(List<Integer> numbers) {
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        return (max <= 45 && min >= 1);
    }

    public boolean checkRange(int number) {
        return (number <= 45 && number >= 1);
    }
}
