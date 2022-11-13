package controller;

public class Validator {
    public static final int ONE_THOUSAND = 1000;
    public static int isNumber(String purchasingMoney) {
        for(int i=0; i < purchasingMoney.length(); i++) {
            if (!Character.isDigit(purchasingMoney.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(purchasingMoney);
    }
    public static void isDivideBy1000(int money) {
        if(money % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException();
        }
    }
}
