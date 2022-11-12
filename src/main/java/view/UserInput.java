package view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private String input;
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    //당첨번호 입력받기
    public String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
       input  = Console.readLine();
       validateWinningNumber(input);
       return input;
    }

    //로또 구입 금액 입력받기
    public String inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        input = Console.readLine();
        validateIsDigit(input);
        return input;
    }

    //보너스 번호 입력받기
    public String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
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
