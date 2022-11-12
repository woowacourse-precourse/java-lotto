package lotto;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public void creteWinningNumbers() {
        InputView inputView = new InputView();
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> winningStringNumbers = List.of(winningNumber.split(","));
        for (int i=0; i<winningStringNumbers.size(); i++){
            int number = Integer.parseInt(winningStringNumbers.get(i));
            winningNumbers.add(number);
        }
    }
}