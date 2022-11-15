package lotto;

import static lotto.NumberType.NUMBER_COUNT;
import static lotto.NumberType.NUMBER_END;
import static lotto.NumberType.NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자 개수가 올바르지 않습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto(){
        return this.numbers;
    }
    public String toString (){
        String Message="[";
        for (int i =  0 ; i< numbers.size(); i++){
                Message = Message +numbers.get(i);
            if (i != numbers.size()-1){
                Message+= ", ";
            }
        }
        Message+="]";
        return Message;
    }

}
