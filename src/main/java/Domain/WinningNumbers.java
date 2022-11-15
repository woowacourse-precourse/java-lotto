package Domain;

import Controller.Validation;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;

    public WinningNumbers(String readWinningNumbers){
        Validation.validateWinningNumberInput(readWinningNumbers);
        this.numbers = getWinningNumbers(readWinningNumbers);
    }

    public List<Integer> getWinningNumbers(String readWinningNumbers){
        String[] splitWinningNumber = readWinningNumbers.split(","); //상수
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i=0; i<6; i++){ //상수
            winningNumbers.add(Integer.parseInt(splitWinningNumber[i]));
        }
        return winningNumbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
