package lotto.util;

public class Validator {

    public static boolean isLottoMoney(int money){
        return money % 1000 == 0;
    }
}
