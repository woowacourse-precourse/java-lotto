package Domain;

import Controller.Validation;
import View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private List<Integer> numbers;

    public Winning(){
        numbers = getWinningNumbers();
    }

    public List<Integer> getWinningNumbers(){
        InputView.printInputWinningNumberMessage();
        String readWinningNumber = InputView.readInputLine();
        Validation.validateWinningNumberInput(readWinningNumber);
        String[] a = readWinningNumber.split(","); //상수
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i=0; i<6; i++){ //상수
            winningNumbers.add(Integer.parseInt(a[i]));
        }
        return winningNumbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
