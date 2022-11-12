package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final int LOTTO_MAX_NUMBER=45;
    private final int LOTTO_MIN_NUMBER=1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isListSizeIsSix(numbers)||hasDuplicatedNumber(numbers)||hasOverRangeNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasOverRangeNumber(List<Integer> numbers) {
        return numbers.stream().filter(i->i< LOTTO_MIN_NUMBER).filter(i-> LOTTO_MAX_NUMBER <i).count()!=0;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {

        for(Integer number:numbers){
            if(Collections.frequency(numbers,number)>1){
                return true;
            }
        }
        return false;
    }

    private static boolean isListSizeIsSix(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }


    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    // TODO: 추가 기능 구현
}
