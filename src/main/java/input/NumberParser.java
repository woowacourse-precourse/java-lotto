package input;

import java.util.List;
import java.util.ArrayList;

public class NumberParser {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;
    public List<Integer> getWinningNumbers(String rawNumbers) {
        String[] splittedNumbers = rawNumbers.split(",");
        try {
            for (String number : splittedNumbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
            System.out.println(winningNumbers);
            return winningNumbers;
        }catch(Exception e){
            System.out.println("임시 에러: 숫자를 입력해야 한다.");
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber(String rawNumber){
        try {
            bonusNumber = Integer.parseInt(rawNumber);
            System.out.println(bonusNumber);
            return bonusNumber;
        } catch(Exception e) {
            System.out.print("임시 에러: 숫자를 입력해야 한다.");
            throw new IllegalArgumentException();
        }
    }

    public NumberParser(List<Integer> numbers) {
        winningNumbers = numbers;
    }

    public NumberParser(int number){
        bonusNumber = number;
    }

    public NumberParser(){}

    public void checkException(List<Integer> numbers) {
        if(numbers.size() != 6){
            System.out.println("임시에러: 숫자 6개만 넣어야한다.");
            throw new IllegalArgumentException();
        }
        for(int number : numbers) {
            checkException(number);
        }
    }

    public void checkException(int number) {
        if(number < 0 || number < 45){
            System.out.println("임시에러: 1부터 45사이의 숫자여야한다.");
            throw new IllegalArgumentException();
        }
    }
}
