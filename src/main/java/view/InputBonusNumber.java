package view;

import camp.nextstep.edu.missionutils.Console;
import constant.ErrorMessage;

public class InputBonusNumber {


    public static void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
        String inputBonusNumber = Console.readLine();
        validateBonusNumber(inputBonusNumber);

    }

    public static void validateBonusNumber(String inputBonusNumber){
        int bonusNumber=0;
        try{
           bonusNumber = Integer.parseInt(inputBonusNumber);
       }
       catch (Exception e){
           throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_NOTNUMBER.getMessage());
       }

        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ErrorMessage.ERROR_BONUS_OVERRANGE.getMessage());
        }
    }

}
