package lotto;

import java.util.HashSet;

public class Exception {

    //숫자가 아닌 문자 입력시 예외처리
    public boolean isNumeric(String number){
        for(int i=0;i<number.length();i++){
            if('0'<=number.charAt(i)&&number.charAt(i)<='9')continue;
            return false;
        }
        return true;
    }

    public boolean moneyValidator(int money){
        if(money%1000==0&&money>1000)return true;
        return false;
    }

    public boolean lottoValidator(int number){
        if(1<=number&&number<=45) {
            return true;
        }
        return false;
    }

}
