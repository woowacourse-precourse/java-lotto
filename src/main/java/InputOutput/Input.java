package InputOutput;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public List<Integer> getWinningNumberList(){
        return winningNumberList;
    }

    public int getInputPrice(){
        return inputPrice;
    }
    public int getBonusNumber(){
        Print.BonusNumber();
        return bonusNumber;
    }


    public List<Integer> inputWinningNumber() {
        String[] inputString = Console.readLine().split(",");
        validateIntegerWinningNumber(inputString);
        validateOverlapedWinningNumber(inputString);
        return Revert.revertStringArrayToIntegerList(inputString);
    }

    public int inputBonusNumber(){
        String bonus =Console.readLine();
        validateInteger(bonus);
        validateRange(bonus);
        return Integer.parseInt(bonus);
    }


    private void validateIntegerWinningNumber(String[] stringArray){
        for(String string: stringArray){
            validateInteger(string);
            validateRange(string);
        }
    }
    private void validateOverlapedWinningNumber(String[] stringArray){
        List<Integer> List= Revert.revertStringArrayToIntegerList(stringArray);
        Set<Integer> numSet = new HashSet<>(List);
        if(numSet.size()!=List.size()){
            Print.errorMessage("중복되는 값이 있습니다.");
            throw new IllegalArgumentException();
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
