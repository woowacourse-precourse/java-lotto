package lotto;

import java.util.List;
import java.util.Scanner;

public class Checker {
    private List<Integer> winNumber;
    private int bonusNumber;
    public void chooseNumber(){
        chooseWinNumber();
        chooseBonusNumber();
    }
    private void chooseWinNumber(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        validateWinNumber(input);
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            winNumber.add(Integer.parseInt(i));
        }
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
    private void chooseBonusNumber(){
        Scanner scanner = new Scanner(System.in);
        try{
            bonusNumber = scanner.nextInt();
        }
        catch(Exception e) {
            throw new IllegalArgumentException();
        }
        validateBonusNumber(bonusNumber);
    }
    private void validateBonusNumber(int input){
        if(input < 1 || input > 45)
            throw new IllegalArgumentException();
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public void setWinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
