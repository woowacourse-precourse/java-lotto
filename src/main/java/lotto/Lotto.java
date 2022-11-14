package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.CommonContent.PrintError.LOTTONUMBEROVERRAPERROR;
import static lotto.CommonContent.PrintError.LOTTOSIZEERROR;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTOSIZEERROR.getPrintStatement());
        }
        Set<Integer> numSet = new HashSet<>(numbers);

        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException(LOTTONUMBEROVERRAPERROR.getPrintStatement());
        }

    }

    public List<Integer> getNumbers() {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public boolean contains(Integer number){
        return numbers.contains(number);
    }
}
