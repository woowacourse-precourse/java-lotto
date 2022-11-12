package lotto;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    public void creteWinningNumbers() {
        InputView inputView = new InputView();
        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> winningStringNumbers = List.of(winningNumber.split(","));
        for (int i=0; i<winningStringNumbers.size(); i++){
            int number = Integer.parseInt(winningStringNumbers.get(i));
            winningNumbers.add(number);
        }
    }
}