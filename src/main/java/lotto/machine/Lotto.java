package lotto.machine;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidCheck.Lotto_length(numbers);
        ValidCheck.Lotto_range(numbers);
        ValidCheck.Lotto_duplicated(numbers);
    }

    public List<Integer> get_value() {
        return this.numbers;
    }

    public Integer compare(List<Integer> winning_numbers) {
        Integer res = 0;
        for(int index = 0; index<winning_numbers.size(); index++) {
            if(this.numbers.contains(winning_numbers.get(index))) res++;
        }

        return res;
    }

    public Boolean compare(Integer Bonus) {
        return this.numbers.contains(Bonus);
    }
}
