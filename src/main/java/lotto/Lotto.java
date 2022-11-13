package lotto;

import camp.nextstep.edu.missionutils.Console;

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
    
    public Integer read() throws IllegalArgumentException{
        try{
            int purchaseAmount = Integer.valueOf(Console.readLine().strip());
            return purchaseAmount;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public Integer numOfTickets(int money){
        if (money > 1000){
            return money / 1000;
        }
        return 0;
    }
}
