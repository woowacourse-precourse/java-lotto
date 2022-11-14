package lotto.domain;

public class BuyLotto {
    public static final int MININUM_LOTTO_PURCHASE = 1000;

    public static Integer howMuchBuy(String inputHowMuch){
        return howMuchStringToInt(inputHowMuch);
    }

    private static  Integer howMuchStringToInt(String inputHowMuch) {
        return Integer.parseInt(inputHowMuch);
    }
    
}
