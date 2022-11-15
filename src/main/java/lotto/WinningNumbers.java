package lotto;

import java.util.List;
import java.util.StringTokenizer;

import static lotto.Application.printErrorMessage;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String input){

    }

    private void winningNumbersSplit(String s){
        StringTokenizer tokenizer= new StringTokenizer(s,",");
        while(tokenizer.hasMoreTokens()){
            integerCheck(tokenizer.nextToken());
        }
    }

    private void integerCheck(String num) {
        try{
             int winNum = Integer.parseInt(num);
        }
        catch(NumberFormatException e){
            printErrorMessage("[ERROR] 숫자 형식으로만 입력해주세요.");
        }

    }


}
