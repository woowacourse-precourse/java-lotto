package lotto.domain;

import java.util.List;

public class ValidUserInput {
    public static void isInputNumberInteger(String inputMoney){
        char check;
        for(int i = 0; i < inputMoney.length(); i++){
            check = inputMoney.charAt(i);
            if(check < 48 || check > 58){
                throw new IllegalArgumentException("[ERROR] 입력한 금액이 숫자가 아닙니다.");
            }
        }
    }

    public static void isInputMoneyDivideThousand(String inputMoney){
        int money = Integer.parseInt(inputMoney);
        if((money % 1000) != 0){
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 지지 않습니다.");
        }
    }

    public static void isBonusNumberNotSameRandomNumber(int bonusNumber, List<Integer> userInputNumber){
        if(userInputNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 볼이 자동 생성된 로또 번호와 같습니다.");
        }
    }

    public static void isInputNumberOverZero(String input){
        int money = Integer.parseInt(input);
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 음수를 입력 할 수 없습니다.");
        }
    }


}
