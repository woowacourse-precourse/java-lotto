package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAmount(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // test: test/java/lotto/LottoTest/createLottoByOverSize()
    private void validateAmount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // test: test/java/lotto/LottoTest/createLottoByDuplicatedNumber()
    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> testSet = new HashSet<>(numbers);
        if(numbers.size() != testSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        String returnString = "[";
        for(int i=0 ; i<6 ; i++) {
            returnString = returnString + numbers.get(i);
            if(i != 5) {
                returnString = returnString + ", ";
            }
        }
        returnString = returnString + "]";
        return returnString;
    }
}
