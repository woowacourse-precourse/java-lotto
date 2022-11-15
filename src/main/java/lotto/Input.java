package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private int money;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int bonusNumber;
    public List<Integer> getNumbers() { return this.numbers; }
    public int getMoney() { return this.money; }
    public int getBonusNumber() { return this.bonusNumber; }
    
    public Input() {
        System.out.println("구입 금액을 입력해 주세요.");
        String inputmoney = Console.readLine();
        if(checkMoney(inputmoney)) {
            this.money = Integer.parseInt(inputmoney);
        }
        System.out.println();
    }
    public void enterNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputnumbers = Console.readLine();
        splitNumbers(inputnumbers);
        System.out.println();
    }
    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputbonusnumber = Console.readLine();
        if(checkBonusNumber(inputbonusnumber)){
            this.bonusNumber = Integer.parseInt(inputbonusnumber);
        }
        System.out.println();
    }
    private boolean checkBonusNumber(String inputbonusnumber) {
        int n=Integer.parseInt(inputbonusnumber);
        if(n<1 || n>45 || this.numbers.contains(n)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 잘못 입력 하셨습니다.");
        }
        return true;
    }
    private void splitNumbers(String userInput) {
        String[] splitstring = userInput.split(",", 6);
        if(splitstring.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 잘못 입력 하셨습니다.");
        }
        if(checkNumbers(splitstring)) {
            for (String s : splitstring) {
                this.numbers.add(Integer.parseInt(s));
            }
        }
    }
    private boolean checkMoney(String inputmoney) {
        try {
            Integer.parseInt(inputmoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        int money = Integer.parseInt(inputmoney);
        if((money % 1000) != 0)
            throw new IllegalArgumentException("[ERROR] 구매 금액을 잘못 입력 하셨습니다.");
        return true;
    }
    private boolean checkNumbers(String[] splitstring) {
        try{
            for(String s : splitstring) Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 잘못 입력 하셨습니다.");
        }
        return true;
    }
}