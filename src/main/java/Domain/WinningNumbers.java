package Domain;

import Controller.Constant;
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
        String[] splitWinningNumber = readWinningNumbers.split(Constant.SEPARATOR);
        List<Integer> winningNumbers = new ArrayList<>();
        for(int index=0; index<Constant.LOTTO_LENGTH; index++){
            winningNumbers.add(Integer.parseInt(splitWinningNumber[index]));
        }
        return winningNumbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
