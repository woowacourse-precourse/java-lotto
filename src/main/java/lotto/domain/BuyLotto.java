package lotto.domain;

public class BuyLotto {
    private static final int MININUM_LOTTO_PURCHASE = 1000;

    public static Integer howMuchBuy(String inputHowMuch){
        return howMuchStringToInt(inputHowMuch)/MININUM_LOTTO_PURCHASE;
    }

    private static  Integer howMuchStringToInt(String inputHowMuch) {
        return Integer.parseInt(inputHowMuch);
    }
    
}
