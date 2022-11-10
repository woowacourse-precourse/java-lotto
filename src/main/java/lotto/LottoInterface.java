package lotto;

import java.util.List;

public interface LottoInterface {
    void validate(List<Integer> numbers);
    void validateLottoSize(List<Integer> numbers);

    static void validateLottoNumberRange(List<Integer> numbers){
        final int startRange = 1;
        final int endRange = 45;
        for(int number : numbers){
            if(number < startRange || number > endRange){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    static void validateLottoNumberDuplicated(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되서는 안됩니다");
        }
    }
}
