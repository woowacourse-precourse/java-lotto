package lotto;

import java.util.List;
import java.util.Scanner;

public class Checker {
    private List<Integer> winNumber;
    private int bonusNumber;
    public void chooseWinNumber(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validateWinNumber(input);
    }
    private void validateWinNumber(String input){
        isProperComma(input);
        isNumber(input);
        isInRange(input);
    }
    private void isProperComma(String input){
        if(input.split(",").length != 6)
            throw new IllegalArgumentException();
    }
    private void isNumber(String input){
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            if(!isNumeric(i))
                throw new IllegalArgumentException();
        }
    }
    private void isInRange(String input){
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            if(Integer.parseInt(i) < 1 || Integer.parseInt(i) > 45)
                throw new IllegalArgumentException();
        }
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public void chooseBonusNumber(){

    }
}
