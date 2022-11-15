package lotto;

import java.util.List;

import static lotto.Validation.sizeValidate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sizeValidate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers(){
        System.out.println(numbers);
    }

    public boolean containNumbers(int number){
        if(numbers.contains(number)){
            return true;
        }
        return false;
    }

    public int countNumbers(Lotto winnerLotto){
        int cnt = 0;
        for(int num : winnerLotto.numbers){
            if(this.containNumbers(num)){
                cnt++;
            }
        }
        return cnt;
    }
}
