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

    private Integer integerCheck(String num) {
        Integer winNum = 0;
        try{
             winNum = Integer.parseInt(num);
        }
        catch(NumberFormatException e){
            printErrorMessage("[ERROR] 숫자 형식으로만 입력해주세요.");
        }
        return winNum;
    }


}
