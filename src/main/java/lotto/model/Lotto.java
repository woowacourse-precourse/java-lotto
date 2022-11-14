package lotto.model;

import java.util.List;

import static lotto.utils.ExceptionMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateLottoDistinct(numbers);
        validateLottoRange(numbers);
    }
    private void validateLottoCount(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_SIX_EXCEPTION);
        }
    }

    private void validateLottoDistinct(List<Integer> numbers){
        int distinctCount =(int) numbers.stream()
                .distinct()
                .count();
        if(distinctCount!=numbers.size()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_Distinct_EXCEPTION);
        }
    }
    private void validateLottoRange(List<Integer> numbers){
        for(int number : numbers){
            if(number>45||number<1){
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_EXCEPTION);
            }
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public int countSameNum(Lotto lotto){
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }


    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }
}
