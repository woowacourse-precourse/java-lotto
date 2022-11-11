package view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private String input;

    //당첨번호 입력받기
    public String inputWinningNumber(){
       input  = Console.readLine();
       validateWinningNumber(input);
       return input;
    }

    //로또 구입 금액 입력받기
    public String inputMoney(){
        input = Console.readLine();
        validateIsDigit(input);
        return input;
    }

    //보너스 번호 입력받기
    public String inputBonusNumber(){
        input = Console.readLine();
        validateIsDigit(input);
        return input;
    }

    //당첨번호 검증하기1 (숫자와 ,이 입력되었는지)
    public void validateWinningNumber(String input){
        if(!input.matches("([0-9]{1,3}\\,)*([0-9]{1,3})")){
            throw new IllegalArgumentException();
        }
    }

    //보너스 번호와 구입 금액 검증하기1 (숫자인지)
    public void validateIsDigit(String input){
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
    }

}
