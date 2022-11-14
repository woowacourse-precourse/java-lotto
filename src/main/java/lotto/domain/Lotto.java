package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "6자리가 아닙니다");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumber(List<Integer> numbers){
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != 6){
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 숫자입니다.");
        }
    }

    public List<Integer> getLottoNumber(){
        return Collections.unmodifiableList(numbers);
    }


//    public int correctLottoNumber(Lotto winningLotto, Lotto lotto){
//        int correctCount;
//        for(int i = 0; i < 6; i++){
//            if()
//        }
//    }
}
