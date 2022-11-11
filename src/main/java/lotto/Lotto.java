package lotto;

import java.util.List;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicated(numbers);
    }

    public void validateLottoSize(List<Integer> numbers){
        final int LottoSize = 6;
        if(numbers.size() != LottoSize){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers){
        final int startRange = 1;
        final int endRange = 45;
        for(int number : numbers){
            if(number < startRange || number > endRange){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public void validateLottoNumberDuplicated(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되서는 안됩니다");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
