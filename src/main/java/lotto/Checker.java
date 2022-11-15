package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Checker {
    private List<Integer> winNumber;
    private int bonusNumber;

    private void chooseWinNumber(){
        winNumber = new ArrayList<Integer>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateWinNumber(input);
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            winNumber.add(Integer.parseInt(i));
        }
    }
    private void validateWinNumber(String input){
        isProperComma(input);
        isFirstAndLastNumeric(input);
        isDuplicate(input);
        isNumber(input);
        isInRange(input);
    }
    private void isProperComma(String input){
        if(input.split(",").length != 6) {
            System.out.println("[ERROR] 로또 번호 입력은 '1,2,3,4,5,6' 포맷을 사용해야 합니다.");
            throw new NoSuchElementException();
        }
    }
    private void isFirstAndLastNumeric(String input){
        if(!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length()-1))) {
            System.out.println("[ERROR] 로또 번호의 입력은 '1,2,3,4,5,6' 포맷을 사용해야 합니다.");
            throw new NoSuchElementException();
        }
    }
    private void isDuplicate(String input){
        String[] splitInput = input.split(",");
        for(int i = 0; i < splitInput.length-1; i++) {
            for (int j = i+1; j < splitInput.length; j++) {
                if (splitInput[i].equals(splitInput[j])) {
                    System.out.println("[ERROR] 로또 번호는 중복된 값을 허용하지 않습니다.");
                    throw new NoSuchElementException();
                }
            }
        }
    }
    private void chooseBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        try{
            bonusNumber = Integer.parseInt(Console.readLine());
        }
        catch(Exception e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new NoSuchElementException();
        }
        validateBonusNumber();
    }
    private void validateBonusNumber(){
        isBonusInRange();
        isBonusDuplicate();
    }

    private void isNumber(String input){
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            if(!isNumeric(i)) {
                System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
                throw new NoSuchElementException();
            }
        }
    }
    private void isInRange(String input){
        String[] splitInput = input.split(",");
        for(String i: splitInput){
            if(Integer.parseInt(i) < 1 || Integer.parseInt(i) > 45) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new NoSuchElementException();
            }
        }
    }
    public void chooseNumber(){
        chooseWinNumber();
        chooseBonusNumber();
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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

    public void isBonusDuplicate(){
        if(winNumber.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호에 포함되지 않은 번호여야 합니다.");
            throw new NoSuchElementException();
        }
    }

    public void isBonusInRange(){
        if(bonusNumber < 1 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new NoSuchElementException();
        }
    }
    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
