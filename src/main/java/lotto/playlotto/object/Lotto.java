package lotto.playlotto.object;

import lotto.input_output.Input;
import lotto.valid.Valid;

import java.util.List;

public class Lotto extends Input {
    private final List<Integer> numbers;    //로또를 시작할 때 사용자에게 입력받는 값

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        check_Overlap(numbers);
        check_size(numbers);
        check_Range(numbers);
    }


    public List<Integer> returnNumbers(){
        return this.numbers;
    }



}
