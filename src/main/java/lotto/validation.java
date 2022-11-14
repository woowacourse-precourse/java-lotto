package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;
import static lotto.Application.throwException;

public class validation {

    public static int validateBudget(String input){
        int budget = 0;
        try{
            budget = Integer.parseInt(input);
        }catch(NumberFormatException e){throwException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");}
        if (budget % 1000 != 0) throwException("구입 금액은 1000의 배수여야 합니다.");
        System.out.println("\n" + (budget/1000) + "개를 구매했습니다.");
        return (budget / 1000);
    }

    public static Lotto validateLottoAnswers(String input){
        List<Integer> numberList = new ArrayList<>();
        String[] strings = input.split(",");
        for(int i=0; i<strings.length; i++){
            try{
                int elem = Integer.parseInt(strings[i]);
                numberList.add(elem);
            }catch(NumberFormatException e){throwException("당첨 번호는 모두 숫자이어야 합니다.");}
        }
        if(!isUniqueList(numberList)) throwException("당첨 번호는 중복되지 않아야 합니다.");
        return new Lotto(numberList);
    }

    public static int validateBonusNumber(List<Integer> numberList, String input){
        int bonusNumber = 0;
        try{
            bonusNumber = Integer.parseInt(input);
        }catch(NumberFormatException e){throwException("보너스 번호는 숫자이어야 합니다.");}
        if(numberList.contains(bonusNumber)) throwException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        return bonusNumber;
    }

}
