package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    private static int bonus;

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
        for(int n = 0; n < 6; n++){
            int tempNum = val(input, n);
            result.add(tempNum);
        }
        bonus = val(input, 7);
        return result;
    }
    
    public int val(List<String> in, int num) throws IllegalArgumentException{
        try{
            int temp = Integer.valueOf(in.get(num));
            if (temp < 45 && temp > 0){
                return temp;
            }
        }
        catch(Exception e){
            throw e;
        }
        return 0;
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
    
    public void compare(List<Integer> win, List<List> purchased){
        int count = 0;
        
        for(List l : purchased){
            for(Object o : l){
                if(win.contains(o)){
                    count++;
                }
            }
        }
    }
}
