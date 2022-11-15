package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Check {
    public static int convertMoneytoCount(String money){
        int count=0;
        try{
            count = Integer.parseInt(money);

        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LIST_TYPE.getDesc());
        }
        return count;
    }
    public static int divideThousand(int count){
        if(count%1000!=0 || count <1000){
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getDesc());
        }
        return count/1000;
    }

    public static List<Integer> checkInputLotto(String input){
        List<Integer> beforeUserLotto = new ArrayList<>();
        try {
            String[] splitInput = input.split(",");
            for(int i=0;i<splitInput.length;i++){
                Integer number = Integer.parseInt(splitInput[i]);
                beforeUserLotto.add(number);
            }

        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LIST_TYPE.getDesc());
        }
        Collections.sort(beforeUserLotto);
        return beforeUserLotto;
    }
    public static int checkBonusNum(String bonus){
        int bonusNum=0;
        try {
            bonusNum = Integer.parseInt(bonus);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_TYPE.getDesc());
        }
        return bonusNum;
    }
}
