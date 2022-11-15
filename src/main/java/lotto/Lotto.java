package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers)
    {
        this(numbers, false);
    }

    public Lotto(List<Integer> numbers, boolean isDraw)
    {
        validate(numbers, isDraw);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, boolean isDraw)
    {
        if(!isDraw && numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개입니다.");

        for(int number : numbers)
        {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size())
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되면 안됩니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}