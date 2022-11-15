package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer LottoSize = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    
    public void print_Numbers(){
        System.out.println(numbers);
    }

    public int get_CorrectNumbers(Lotto WinningNumber, int bonus){
        int count = 0;
        for(int i = 0; i < LottoSize; i++){
            if(numbers.contains(WinningNumber.numbers.get(i))) 
            count++;
        }

        //have 6 numbers include bonus number
        if(count == 5 && numbers.contains(bonus))
            count = 7;
        return count;
    }
}
