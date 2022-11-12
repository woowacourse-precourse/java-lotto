package lotto;

public class Exception {

    //숫자가 아닌 문자 입력시 예외처리
    public boolean isNumeric(int money){
        try {
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //천원 단위 나누어 떨어지지 않을시 예외처리
    public boolean divThousandOfMoney(int money){
        if(money%1000==0)return true;
        else return false;
    }
}
