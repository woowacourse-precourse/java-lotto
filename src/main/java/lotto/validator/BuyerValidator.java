package lotto.validator;

public class BuyerValidator {

    public static void checkIsNum(String input) throws IllegalArgumentException{
        try{
            Long.valueOf(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자형식이 아닙니다.");
        }
    }

    public static void checkIsMultipleThousand(long haveMoney) throws IllegalArgumentException{
        if((haveMoney%1000)!=0) throw new IllegalArgumentException("[ERROR]구입하려는 금액이 천원 단위가 아닙니다.");
    }
}
