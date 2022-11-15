package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkForSameLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForSameLottoNumbers(List <Integer> numbers){
        ArrayList<Integer> temp = new ArrayList<>();
        for(Integer number: numbers){
            if(!temp.contains(number)){
                temp.add(number);
            }
            else{
                throw new IllegalArgumentException("[Error] 중복된 숫자가 있습니다.");
            }
        }
    }

    public boolean hasWinningNumber(Integer winningNumber){
        return numbers.contains(winningNumber);
    }

    public void print() {
        System.out.println(numbers);
    }
}
