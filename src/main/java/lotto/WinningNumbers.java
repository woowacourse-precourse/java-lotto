package lotto;

import java.util.List;

import static lotto.Application.printErrorMessage;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String input){

    }

    private void winningNumbersSplit(String s){
        String[] winningNumSplit =s.split(",");

        for(String num:winningNumSplit){
            winningNumbers.add(integerCheck(num));
        }
    }



}
