package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> NumberReturn(){
        return numbers;
    }

    public int Matching(List<Integer> WinningNumber,int Bonus){
        int sum = 0;
        for(int i :WinningNumber){
            for(int j : numbers){
                if(i==j)sum++;
            }
        }
        for(int j : numbers){
            if(sum==5&&j == Bonus)sum+=2;
        }
        return sum;
    }

}
