package lotto;

import java.util.HashSet;

public class Exception {

    private HashSet<Integer> overlapNumber;

    //숫자가 아닌 문자 입력시 예외처리
    public boolean isNumeric(int money){
        return true;
    }

    public boolean divThousandOfMoney(int money){
        if(money%1000==0)return true;
        return false;
    }

    public boolean lessThanThousand(int money){
        if(money>1000)return true;
        return false;
    }

    public boolean lottoValidator(int number){
        if(1<=number&&number<=45) {
            overlapNumber.add(number);
            return true;
        }
        return false;
    }

    public boolean overlapCheck(String type){
        if(type =="lotto"){
            if(overlapNumber.size()==6)return true;
        }

        if(type=="userLotto"){
            if(overlapNumber.size()==7)return true;
        }

        return false;
    }

    public void init(){
        overlapNumber = new HashSet<>();
    }

}
