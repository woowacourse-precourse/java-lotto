package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "6자리가 아닙니다");
        }
    }

    // TODO: 추가 기능 구현

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
