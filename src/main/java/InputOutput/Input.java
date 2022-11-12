package InputOutput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Input {
    private final List<Integer> winningNumberList;
    private final int inputPrice;
    private final int bonusNumber;


    public int inputPrice() {
        String price = Console.readLine();
        validateInteger(price);
        return Integer.parseInt(price);
    }

    public Input(){
        this.winningNumberList = inputWinningNumber();
        this.inputPrice = inputPrice();
        this.bonusNumber= inputBonusNumber();
    }


    public List<Integer> inputWinningNumber() {
        String[] inputString = Console.readLine().split(",");
        validateWinningNumber(inputString);
        return Revert.revertStringArrayToIntegerList(inputString);
    }

    public int inputBonusNumber(){
        String bonus =Console.readLine();
        validateInteger(bonus);
        validateRange(bonus);
        return Integer.parseInt(bonus);
    }


    private void validateWinningNumber(String[] stringArray){
        for(String string: stringArray){
            validateInteger(string);
            validateRange(string);
        }
    }

    private void validateInteger(String string){
        if(!string.matches("-?\\\\d+")){
            Print.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String StringNumber){
        int number= Integer.parseInt(StringNumber);
        if(!(number>0 && number<46)){
            Print.errorMessage("입력값의 범위가 맞지 않습니다..");
            throw new IllegalArgumentException();
        }
    }



}
