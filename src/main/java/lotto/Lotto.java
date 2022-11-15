package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.constant.Constant;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer LottoSize = 6;
    private static Constant constant = new Constant();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(numbers.size() != LottoSize)
            throw new IllegalArgumentException(constant.Print_CountNumbers());

        for(int i : numbers)
            if(i < 1 && i  > 45)
                throw new IllegalArgumentException(constant.Print_OutOfBounds());

        HashSet<Integer> Check_Duplicate_Num = new HashSet<Integer>(numbers);
        if(LottoSize != Check_Duplicate_Num.size())
            throw new IllegalArgumentException(constant.Print_Duplicate_Numbers());
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
