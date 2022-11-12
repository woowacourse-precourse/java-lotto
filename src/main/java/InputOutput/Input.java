package InputOutput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Input {
    private final List<Integer> winningNumberList;
    private final int inputPrice;


    public int inputPrice() {
        String price = Console.readLine();
        validateInteger(price);
        return Integer.parseInt(price);
    }

    public Input(List<Integer> winningNumber, int inputPrice){
        this.winningNumberList = winningNumber;
        this.inputPrice = inputPrice;
    }


    public List<Integer> inputWinningNumber() {
        String[] inputString = Console.readLine().split(",");
        validateWinningNumber(inputString);
        return Revert.revertStringArrayToIntegerList(inputString);
    }


    private void validateWinningNumber(String[] stringArray){
        for(String string: stringArray){
            validateInteger(string);
        }
    }

    private void validateInteger(String string){
        if(!string.matches("-?\\\\d+")){
            Print.errorMessage("입력값이 옳지 않습니다.");
            throw new IllegalArgumentException();
        }
    }




}
