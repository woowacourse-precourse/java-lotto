package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    private static int bonusNum;
    
    /*
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
    */
    
    enum winnings {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH,
        NONE
    }

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
        IllegalArgumentException exception = new IllegalArgumentException();
        String[] temp = input.get(0).split(",");
        List<Integer> result = new ArrayList<>();
        for(int n = 0; n < 6; n++){
            int tempNum = val(input, n);
            if (result.contains(tempNum)){
                throw exception;
            }
            result.add(tempNum);
        }
        bonusNum = val(input, 7);
        if(result.contains(bonusNum)){
            throw exception;
        }
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
    }
    
    public winnings winAmount(int count, boolean bonus){
        if (count == 6){
            return winnings.FIRST;
        }
        if (count == 5 && bonus == true){
            return winnings.SECOND;
        }
        if(count == 5){
            return winnings.THIRD;
        }
        if(count == 4){
            return winnings.FOURTH;
        }
        if(count == 3){
            return winnings.FIFTH;
        }
        return winnings.NONE;
    }
}
