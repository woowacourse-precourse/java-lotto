package lotto.domain;

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
    public static void isInputNumberOverZero(String input){
        int money = Integer.parseInt(input);
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 음수를 입력 할 수 없습니다.");
        }
    }
}
