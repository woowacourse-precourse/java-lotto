package lotto;

import static lotto.Validator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto(){
        return this.numbers;
    }

    public ArrayList<Integer> copyLotto() {
        ArrayList<Integer> lottoCopy = new ArrayList<>(numbers.size());
        for (int i = 0 ; i< numbers.size(); i++) {
            lottoCopy.add(numbers.get(i));
        }
        return lottoCopy;
    }
    public ArrayList<Integer> sortLotto() {
        ArrayList<Integer> sortedLotto =copyLotto();
        Collections.sort(sortedLotto);
        return sortedLotto;
    }
    public String toString (){
        ArrayList<Integer> sortedLotto = sortLotto();
        String lottoString="[";
        for (int i =  0 ; i< sortedLotto.size(); i++){
            lottoString = lottoString +sortedLotto.get(i);
            if (i != sortedLotto.size()-1){
                lottoString+= ", ";
            }
        }
        lottoString+="]";
        return lottoString;
    }

    private void validate(List<Integer> numbers) {
        try
        {
            for (int i = 0 ; i< numbers.size() ; i++)
                isValidateNumberRange(numbers.get(i));
            isValidateNumberLength(numbers);
            isDuplicated(numbers);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
