package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final int minLottoNumber = 1;
        final int maxLottoNumber = 45;
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != 6) throw new IllegalArgumentException();
        if(numbers.size() != numberSet.size()) throw new IllegalArgumentException();
        for(int num : numbers){
            if(num < minLottoNumber || num > maxLottoNumber) throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumber(){
        return numbers;
    }
}