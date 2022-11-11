package controller;

public class Vaildator {
    public static int isNumber(String purchasingMoney) {
        for(int i=0; i < purchasingMoney.length(); i++) {
            if (!Character.isDigit(purchasingMoney.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(purchasingMoney);
    }
    public static void isDivideBy1000(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
