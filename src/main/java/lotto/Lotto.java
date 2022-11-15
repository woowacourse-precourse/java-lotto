package lotto;

import static lotto.Validator.*;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto(){
        return this.numbers;
    }

    public String toString (){
        String lottoString="[";
        for (int i =  0 ; i< numbers.size(); i++){
            lottoString = lottoString +numbers.get(i);
            if (i != numbers.size()-1){
                lottoString+= ", ";
            }
        }
        lottoString+="]";
        return lottoString;
    }

    private void validate(List<Integer> numbers) {
        try
        {
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




}
