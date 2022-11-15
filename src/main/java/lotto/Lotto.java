package lotto;

import java.util.List;

public class Lotto {
    private static int LOTTO_NUMBER_LIMIT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number){
        if(numbers.contains(number)){
            return true;
        }
        return false;
    }
    public List<Integer> copyNumbers(){
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validLottoFalseRange(numbers);
        validCreateLottoByDuplicatedNumber(numbers);
    }
    private void validLottoFalseRange(List<Integer> numbers){
        if (numbers.size() != LOTTO_NUMBER_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
    private void validCreateLottoByDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
