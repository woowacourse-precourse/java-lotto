package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Exceptions.isSameBonusNum;
import static lotto.Exceptions.isSameNumber;

public class WinningNumber {
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int bonusNumber;
    public WinningNumber(){
    }
    public void inputNumber(){
        System.out.println("당첨 번호를 입력하세요.");
        String winningString = Console.readLine();
        splitNumber(winningString);

        System.out.println("보너스 번호를 입력하세요");

        inputBonus();

        validation();
        //printNumber();
    }
    private void validation(){
        isSameNumber(numbers);
        isSameBonusNum(numbers,bonusNumber);
    }


    private void inputBonus(){
        try{
            String bonus = Console.readLine();
            bonusNumber = Integer.parseInt(bonus);
        }
        catch (NumberFormatException e){
            System.out.println( "[ERROR] 숫자만 입력해 주세요" + e.getMessage());
        }
    }
    private void splitNumber(String number){
        String[] stringNumber = number.split(",");
        for(int i = 0 ; i < stringNumber.length; i++){

            numbers.add(Integer.parseInt(stringNumber[i]));
        }
    }
    public void printNumber(){
        System.out.println("당첨번호 : " + numbers );
        System.out.println("보너스 번호 : " + bonusNumber);
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
