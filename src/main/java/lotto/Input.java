package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Input {
    private int money;
    private ArrayList<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public Input() {
        enterMoney();
    }

    private void enterMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userInput = Console.readLine();

        if(validate(userInput)) {
            this.money = parseInt(userInput);
        }

        System.out.println(' ');
    }

    public void enterNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        parseInputToInt(userInput);
        System.out.println(' ');
    }
    
    public void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        
        if(validateBonusNumber(userInput)){
            this.bonusNumber = Integer.parseInt(userInput);
        }
    }

    private boolean validateBonusNumber(String userInput) {
        try{
            int tempNumber = Integer.parseInt(userInput);

            if(!(tempNumber >= 1 && tempNumber <= 45))
                throw new IllegalArgumentException("[Error] 보너스 번호 값의 범위가 1부터 45 사이의 값이 아닙니다.");

            if(this.numbers.contains(tempNumber))
                throw new IllegalArgumentException("[Error] 보너스 번호가 이미 당첨 번호에 있습니다.");

        } catch (Exception e) {
            if(e.getClass() == NumberFormatException.class)
                throw new IllegalArgumentException("[Error] 보너스 번호로 숫자가 아닌 값이 입력 되었습니다.");

            if(e.getClass() == IllegalArgumentException.class)
                throw e;
        }

        return true;
    }

    private void parseInputToInt(String userInput) {
        String[] tempString = userInput.split(",", 6);

        /*
            당첨 번호가 성공적으로 분리되어 배열에 저장되면, 그 배열의 크기는
            항상 6이 된다. 그렇지 않으면 당첨 번호가 쉼표로 구별되지
            않은 것이므로 예외를 발생시킨다.
         */
        if(tempString.length != 6) {
            throw new IllegalArgumentException("[Error] 당첨 번호가 구별되지 않습니다.");
        }

        if(validate(tempString)) {
            for (String s : tempString) {
                this.numbers.add(Integer.parseInt(s));
            }
        }
    }

    private boolean validate(String userInput) {
        if(userInput.charAt(0) == '0')
            throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");

        for(char c :userInput.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        }

        int tempMoney = Integer.parseInt(userInput);

        if((tempMoney % 1000) != 0)
            throw new IllegalArgumentException("[Error] 구매 금액이 천 원으로 나누어 떨어지지 않는 금액입니다.");

        return true;
    }

    private boolean validate(String[] numbers) {
        try{
            for(String s : numbers) {
                Integer.parseInt(s);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[Error] 당첨 번호 중에 숫자가 아닌 값이 존재합니다.");
        }
        
        return true;
    }
    
    public List<Integer> getNumbers() { return this.numbers; }

    public int getMoney() { return this.money; }

    public int getBonusNumber() { return this.bonusNumber; }
}
