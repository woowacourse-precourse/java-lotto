package input;

import java.util.List;
import java.util.ArrayList;

public class NumberParser {
    List<Integer> winningNumbers = new ArrayList<>();
    int bonusNumber;
    public List<Integer> getWinningNumbers(String rawNumbers){
        String[] splittedNumbers = rawNumbers.split(",");
        for(String number : splittedNumbers){
            winningNumbers.add(Integer.parseInt(number));
        }
        System.out.println(winningNumbers);
        return winningNumbers;
    }

    public int getBonusNumber(String rawNumber){
        bonusNumber = Integer.parseInt(rawNumber);
        System.out.println(bonusNumber);
        return bonusNumber;
    }

    public NumberParser(List<Integer> numbers) {
        winningNumbers = numbers;
    }

    public NumberParser(int number){
        bonusNumber = number;
    }

    public NumberParser(){}
}
