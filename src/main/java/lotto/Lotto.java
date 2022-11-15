package lotto;

import static lotto.Validator.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            isValidateNumberLength(numbers);
            isDuplicated(numbers);
            for (int i = 0 ; i< numbers.size() ; i++)
                isValidateNumberRange(numbers.get(i));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }

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
