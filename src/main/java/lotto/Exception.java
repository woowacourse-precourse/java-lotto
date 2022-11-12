package lotto;

public class Exception {

    //숫자가 아닌 문자 입력시 예외처리
    public boolean isNumeric(int money){

    }

    public boolean divThousandOfMoney(int money){
        if(money%1000==0)return true;
        return false;
    }

    public boolean lessThanThousand(int money){
        if(money<1000)return true;
        return false;
    }

    //숫자가 45에 들어가는지
    public boolean lottoValidator(int number){
        if(1<=number&&number<=45)return true;
        return false;
    }
}
