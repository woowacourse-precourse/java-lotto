package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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
    
    public List<String> winInput(){
        List<String> results = new ArrayList<>();
        String winningInput = Console.readLine().strip();
        String bonus = Console.readLine().strip();
        results.add(winningInput);
        results.add(bonus);
        return results;
    }
    
    public List<Integer> validateWin(List<String> input) throws IllegalArgumentException{
        String[] temp = input.get(0).split(",");
        List<Integer> result = new ArrayList<>();
        try{
            for(String i : temp){
                int tempNum = Integer.valueOf(i);
                result.add(tempNum);
            }
            int tempN = Integer.valueOf(input.get(1));
            result.add(tempN);
            return result;
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public List<Integer> gen(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    
    public List<List> purchased(int  n){
        List<List> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Integer> gen = gen();
            result.add(gen);
        }
        return result;
    }
    
    
}
